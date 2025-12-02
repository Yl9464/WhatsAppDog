package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.List;

@Route(value=Employees.ROUTE, layout = MainView.class)

public class Employees extends Div {
    public static  final String ROUTE = "employees";
    public Employees(StaffRepo staffRepo) {
        H1 emplTitle = new H1("Employees");
        GridCrud<Staff> crud = new GridCrud<>(Staff.class);
        Grid<Staff> grid = crud.getGrid(); //access internal grid


        List<Staff> staff = staffRepo.findAll();
        add(emplTitle, grid);
//        for (Staff staff1 : staff) {
//            if("Volunteer".equals(staff1.getJobTitle())) {
//                //volTitle.add(staff1.getFirstName() + " " + staff1.getLastName());
//            }
//            add(employeeTitle,employeeLayout);
        //}

    }
}
