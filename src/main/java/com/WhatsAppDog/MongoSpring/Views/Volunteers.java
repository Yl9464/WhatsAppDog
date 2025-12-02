package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value=Volunteers.ROUTE, layout = MainView.class)

public class Volunteers extends VerticalLayout{
    public static  final String ROUTE = "volunteers";

   // private final StaffRepo staffRepo;
    GridCrud<Staff> crud = new GridCrud<>(Staff.class);
    Grid<Staff> grid =crud.getGrid();

    public Volunteers(StaffRepo staff) {

        H1 h1 = new H1("Volunteers");

        grid.removeAllColumns();
        grid.addColumn(Staff::getFirstName).setHeader("First Name").setSortable(true);
        grid.addColumn(Staff::getLastName).setHeader("Last Name").setSortable(true);
        grid.addColumn(Staff::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(Staff::getJobTitle).setHeader("Position").setSortable(true);
        //add data
        crud.setFindAllOperation(() -> staff.findByJobTitle("Volunteer"));
        crud.setAddOperation(staff::save);


        add(h1, crud);



    }
}
