package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value= DogsView.ROUTE, layout = MainLayout.class)
public class DogsView extends VerticalLayout {
    public static final String ROUTE = "dogs";
   // public static final String TITLE = "Dogs";

    public DogsView() {
        H1 h1 = new H1("Dog Cards to be rendered");
        add(h1);
    }
}
