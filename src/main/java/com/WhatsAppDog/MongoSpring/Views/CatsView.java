package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value= CatsView.ROUTE, layout = MainView.class)
public class CatsView extends VerticalLayout {
    public static final String ROUTE = "cats";
    // public static final String TITLE = "Dogs";

    public CatsView() {
        H1 h1 = new H1("Cat Cards to be rendered");
        add(h1);
    }
}
