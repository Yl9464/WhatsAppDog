package com.WhatsAppDog.MongoSpring;
import com.WhatsAppDog.MongoSpring.Views.AnimalsView;
import com.WhatsAppDog.MongoSpring.Views.HomeView;
import com.WhatsAppDog.MongoSpring.Views.SuppliesView;
import com.WhatsAppDog.MongoSpring.Views.StaffView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout{
    public MainLayout() {
        addToNavbar(new DrawerToggle());
        addToNavbar(new H2("WhatsAppDog"));

        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Home");
        menuBar.addItem("Animals")
                .getSubMenu()
                .addItem("Dogs");
        menuBar.addItem("Cats");
        menuBar.addItem("Other");
        menuBar.addItem("Supplies");
        menuBar.addItem("Staff");

        addToNavbar(menuBar);
        //        final VerticalLayout menuBar = new VerticalLayout();
//        menuBar.add(new RouterLink(HomeView.TITLE, HomeView.class));
//        menuBar.add(new RouterLink(AnimalsView.TITLE, AnimalsView.class));
//        menuBar.add(new RouterLink(SuppliesView.TITLE, SuppliesView.class));
//        menuBar.add(new RouterLink(StaffView.TITLE, StaffView.class));
//        addToDrawer(menuBar);

    }
}