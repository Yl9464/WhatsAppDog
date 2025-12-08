package com.WhatsAppDog.MongoSpring.Views;


import com.WhatsAppDog.MongoSpring.Controller.StaffController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;


@Route(value = StaffView.ROUTE, layout= MainView.class)
public class StaffView extends VerticalLayout{

    public static final String ROUTE = "staff";
    public final StaffController staffController;
    GridCrud<Staff> crud;
     TextField searchTerm = new TextField();

    public StaffView( StaffController staffController)  {
        this.staffController = staffController;
        crud = new GridCrud<>(Staff.class);
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

        //Search Bar
        searchTerm.setPlaceholder("Enter name...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");

        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e ->
                crud.getGrid().setItems(staffController.searchPerson(e.getValue())));

        // CRUD operations
        crud.setAddOperation(     staffController::add);
        crud.setUpdateOperation(  staffController::update);
        crud.setDeleteOperation(  staffController::delete);
        crud.setFindAllOperation( staffController::findAll);

        add(h1, searchTerm, crud);
        setSizeFull();

    }
}
