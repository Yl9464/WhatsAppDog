package com.WhatsAppDog.MongoSpring;

import com.WhatsAppDog.MongoSpring.Views.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;

@CssImport("./styles/styles.css")
public class MainView extends AppLayout{

    public MainView() {
       addToNavbar(new H2("WhatsAppDog"));
       createMenuBar();
    }
    private void createMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Home", e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));

        MenuItem animalItem = menuBar.addItem("Animals");
        SubMenu animalSub = animalItem.getSubMenu();
        addClassName("animalSubMenu");
        animalSub.addItem("Dogs", e -> getUI().ifPresent(ui -> ui.navigate(DogsView.class)));
        animalSub.addItem("Cats",e -> getUI().ifPresent(ui -> ui.navigate(CatsView.class)));
        animalSub.addItem("Other", e -> getUI().ifPresent(ui -> ui.navigate(OthersView.class)));

        menuBar.addItem("Supplies", e -> getUI().ifPresent(ui -> ui.navigate(SuppliesView.class)));
        menuBar.addItem("Staff",  e -> getUI().ifPresent(ui -> ui.navigate(StaffView.class)));

        addToNavbar(menuBar);
    }
}