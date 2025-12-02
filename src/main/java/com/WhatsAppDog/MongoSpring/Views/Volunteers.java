package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value=Volunteers.ROUTE, layout = MainView.class)

public class Volunteers extends Div{
    public static  final String ROUTE = "volunteers";
    public Volunteers(StaffRepo staffRepo) {
        Div volLayout = new Div();
        volLayout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em")
                .set("margin", "2em");
        //getAll Data
        List<Staff> staff = staffRepo.findAll();
        add(volLayout);
    }
}
