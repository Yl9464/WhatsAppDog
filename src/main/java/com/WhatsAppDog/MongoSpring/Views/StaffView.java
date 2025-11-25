package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.io.Serial;
import java.util.List;

@Route(value = StaffView.ROUTE, layout= MainLayout.class)
public class StaffView extends VerticalLayout{

    public static final String ROUTE = "staff";
    public static final String TITLE = "Staff";

    public StaffView(StaffRepo staffRepo) {
        H1 h1 = new H1("Staff Members");
        Grid<Staff> grid = new Grid<>(Staff.class, false);
        grid.addColumn(Staff::getFirstName).setHeader("First Name");
        grid.addColumn(Staff::getLastName).setHeader("Last Name");
        grid.addColumn(Staff::getEmail).setHeader("Email");
        grid.addColumn(Staff::getJobTitle).setHeader("Position");
        grid.addColumn(Staff::getSalary).setHeader("Salary");

        List<Staff> staff = staffRepo.findAll();
        grid.setItems(staff);
        add(h1,grid);

    }
}