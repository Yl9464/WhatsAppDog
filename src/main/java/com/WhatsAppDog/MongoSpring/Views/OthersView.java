package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


    @Route(value= OthersView.ROUTE, layout = MainView.class)
    public class OthersView extends VerticalLayout {
        public static final String ROUTE = "others";


        public OthersView() {
            H1 h1 = new H1("All other animal cards to be rendered");
            add(h1);
        }
    }