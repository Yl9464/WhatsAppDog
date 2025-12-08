package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.StaffController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;

@Route(value=Volunteers.ROUTE, layout = MainView.class)
public class Volunteers extends VerticalLayout{

    public static  final String ROUTE = "volunteers";

    private final StaffController staffController;
    GridCrud<Staff> crud;
    TextField searchTerm = new TextField();

    public Volunteers(StaffController staffController) {
        this.staffController =staffController;
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
        H1 h1 = new H1("Volunteers");
        crud.getGrid().removeAllColumns(); //remove default headers
        //readd custom headers
        crud.getGrid().addColumn(Staff::getFirstName).setHeader("First Name").setSortable(true);;
        crud.getGrid().addColumn(Staff::getLastName).setHeader("Last Name").setSortable(true);;
        crud.getGrid().addColumn(Staff::getEmail).setHeader("Email").setSortable(true);;

        //add data
        crud.setFindAllOperation(() -> staffController.getEmployeeStatus(false));
        crud.setAddOperation(staffController::add);

        //search
        searchTerm.setPlaceholder("Enter name...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");

        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e -> {
            String value = e.getValue();
            crud.getGrid().setItems(staffController.searchPerson(value));
        });

        add(h1,searchTerm, crud);
        setSizeFull();

    }
}