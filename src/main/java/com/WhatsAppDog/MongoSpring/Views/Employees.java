package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value=Employees.ROUTE, layout = MainView.class)

public class Employees extends Div {
    public static  final String ROUTE = "employees";
    public Employees(StaffRepo staffRepo) {
        Div employeeLayout = new Div();
        employeeLayout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em")
                .set("margin", "2em");
        //getAll Data
        List<Staff> staff = staffRepo.findAll();
        add(employeeLayout);
    }
}
