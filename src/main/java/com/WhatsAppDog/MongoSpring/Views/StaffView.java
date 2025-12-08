package com.WhatsAppDog.MongoSpring.Views;


import com.WhatsAppDog.MongoSpring.Controller.StaffController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;

@Route(value = StaffView.ROUTE, layout= MainView.class)
public class StaffView extends VerticalLayout{
    public static final String ROUTE = "staff";

    private final StaffController staffController;
    private final GridCrud<Staff> crud;

    TextField searchTerm = new TextField();

    @Autowired
    public StaffView(StaffController staffController)  {
        this.staffController = staffController;

        crud = new GridCrud<>(Staff.class);

        crud.setCrudListener(new CrudListener<Staff>() {
            @Override
            public Collection<Staff> findAll() {
                return staffController.findAll();
            }

            @Override
            public Staff add(Staff staff) {
                return staffController.add(staff);
            }

            @Override
            public Staff update(Staff staff) {
                return staffController.update(staff);
            }

            @Override
            public void delete(Staff staff) {
                staffController.delete(staff);
            }
        });
        H1 h1  = new H1("Staff Members");

        crud.getGrid().removeAllColumns(); //remove default headers
        //readd custom headers
        crud.getGrid().addColumn(Staff::getFirstName).setHeader("First Name").setSortable(true);;
        crud.getGrid().addColumn(Staff::getLastName).setHeader("Last Name").setSortable(true);;
        crud.getGrid().addColumn(Staff::getEmail).setHeader("Email").setSortable(true);;
        crud.getGrid().addColumn(person ->
                person.isEmployee() ? "Employee" : "Volunteer"
        ).setHeader("Staff Type").setSortable(true);;
        crud.getGrid().addColumn(Staff::getSalary).setHeader("Salary").setSortable(true);;

        //search bar
        searchTerm.setPlaceholder("Enter name...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");

        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e -> {
                    String value = e.getValue();
                    crud.getGrid().setItems(staffController.searchPerson(value));
                });
        // CRUD operations
        crud.setAddOperation(staffController::add);
        crud.setUpdateOperation(staffController::update);
        crud.setDeleteOperation(staffController::delete);
        crud.setFindAllOperation(staffController::findAll);

        add(h1, searchTerm, crud);
        setSizeFull();

    }
}
