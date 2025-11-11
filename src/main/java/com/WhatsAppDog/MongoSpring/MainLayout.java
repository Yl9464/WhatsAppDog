package com.WhatsAppDog.MongoSpring;

import com.WhatsAppDog.MongoSpring.Views.NavBar;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout{
    public MainLayout() {
        addToNavbar(new DrawerToggle());

        final VerticalLayout menuBar = new VerticalLayout();
        menuBar.add(new RouterLink(NavBar.TITLE, NavBar.class));

    }
}
