package com.WhatsAppDog.MongoSpring;

import com.WhatsAppDog.MongoSpring.Views.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;

import java.awt.*;

@CssImport("./styles/styles.css")
public class MainView extends AppLayout{

    public MainView() {
       addToNavbar(new H2("WhatsAppDog"));
       createMenuBar();
    }

    private void createMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Home", e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));

         //menu and submenu
        MenuItem animalItem = menuBar.addItem("Animals",e -> getUI().ifPresent(ui -> ui.navigate(AllAnimalsView.class)));
        //staff submenu
        MenuItem staffItem = menuBar.addItem("Staff");
        SubMenu staffSub = staffItem.getSubMenu();
        addClassName("staffSubMenu"); //css
        staffSub.addItem("All Staff", e -> getUI().ifPresent(ui -> ui.navigate(StaffView.class)));
        staffSub.addItem("Volunteers", e -> getUI().ifPresent(ui -> ui.navigate(Volunteers.class)));
        staffSub.addItem("Employees",  e -> getUI().ifPresent(ui -> ui.navigate(Employees.class)));
        //supplies
        menuBar.addItem("Supplies", e -> getUI().ifPresent(ui -> ui.navigate(SuppliesView.class)));
        addToNavbar(menuBar);
    }
}