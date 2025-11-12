package com.WhatsAppDog.MongoSpring;

import com.WhatsAppDog.MongoSpring.Views.Animals;
import com.WhatsAppDog.MongoSpring.Views.Buttons;
import com.WhatsAppDog.MongoSpring.Views.InventoryTable;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout{
    public MainLayout() {
        addToNavbar(new DrawerToggle());
        addToNavbar(new H2("WhatsAppDog"));

        final VerticalLayout menuBar = new VerticalLayout();

        menuBar.add(new RouterLink(Animals.TITLE, Animals.class));
        menuBar.add(new RouterLink(InventoryTable.TITLE, InventoryTable.class));
        addToDrawer(menuBar);

    }
}
