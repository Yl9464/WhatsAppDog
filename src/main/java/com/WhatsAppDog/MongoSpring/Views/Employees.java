package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value=Employees.ROUTE, layout = MainView.class)

public class Employees extends VerticalLayout {
    public static  final String ROUTE = "employees";

    GridCrud<Staff> crud = new GridCrud<>(Staff.class);
    Grid<Staff> grid =crud.getGrid();
    TextField searchTerm = new TextField();

    public Employees(StaffRepo staff) {
        H1 h1 = new H1("Employees");

        grid.removeAllColumns();
        grid.addColumn(Staff::getFirstName).setHeader("First Name").setSortable(true);
        grid.addColumn(Staff::getLastName).setHeader("Last Name").setSortable(true);
        grid.addColumn(Staff::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(Staff::getSalary).setHeader("Salary").setSortable(true);

        //add data
        crud.setFindAllOperation(() -> staff.findByIsEmployee(true));
        crud.setAddOperation(staff::save);

        //search
        searchTerm.setPlaceholder("Enter name...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");

        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e -> {
            String value = e.getValue();
            crud.getGrid().setItems(staff.searchPerson(value));
        });

        add(h1,searchTerm, crud);
        setSizeFull();


    }
}
