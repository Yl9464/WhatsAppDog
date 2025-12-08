package com.WhatsAppDog.MongoSpring;

import com.WhatsAppDog.MongoSpring.Views.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;

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
        animalSub.addItem("All Animals", e -> getUI().ifPresent(ui ->ui.navigate(AllAnimalsView.class)));
        animalSub.addItem("Medical Form", e -> getUI().ifPresent(ui ->ui.navigate(AnimalMedView.class)));
        menuBar.addItem("Supplies", e -> getUI().ifPresent(ui -> ui.navigate(SuppliesView.class)));
        menuBar.addItem("Staff", e ->getUI().ifPresent(ui -> ui.navigate(StaffView.class)));
        Button logoutBtn = new Button("Logout");
        logoutBtn.addClickListener(e -> {
            VaadinSession.getCurrent().getSession().invalidate();
            getUI().ifPresent(ui -> ui.navigate(""));
        });

        HorizontalLayout menuLayout= new HorizontalLayout(menuBar,logoutBtn);
        addToNavbar(menuLayout);
    }


}