package com.WhatsAppDog.MongoSpring.Views;


import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;


@Route(value = StaffView.ROUTE, layout= MainView.class)
public class StaffView extends VerticalLayout{

    public static final String ROUTE = "staff";
   // private RestTemplate rest = new RestTemplate();

    public StaffView(StaffRepo staff)  {

        GridCrud<Staff> crud = new GridCrud<>(Staff.class);
        crud.setFindAllOperation(staff::findAll);
        crud.setAddOperation(staff::save);
        add(crud);
        setSizeFull();

    }
}

