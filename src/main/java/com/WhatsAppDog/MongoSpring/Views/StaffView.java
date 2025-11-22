package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.io.Serial;

@Route(value = StaffView.ROUTE, layout= MainLayout.class)
public class StaffView extends VerticalLayout{
    @Serial
    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "staff";
    public static final String TITLE = "Staff";

public StaffView(StaffRepo staffRepo) {
    GridCrud<Staff> staffGridCrud = new GridCrud<>(Staff.class);
    staffGridCrud.setFindAllOperation(staffRepo::findAll);

    add(staffGridCrud);
    setSizeFull();
}
}
