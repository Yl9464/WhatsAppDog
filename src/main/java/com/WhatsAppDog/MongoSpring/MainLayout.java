package com.WhatsAppDog.MongoSpring;

import com.WhatsAppDog.MongoSpring.Views.Buttons;
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
        menuBar.add(new RouterLink(Buttons.TITLE, Buttons.class));


    }
}
