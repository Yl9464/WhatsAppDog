package com.WhatsAppDog.MongoSpring.Views;


import com.WhatsAppDog.MongoSpring.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import java.io.Serial;


@Route(value = NavBar.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class NavBar extends VerticalLayout {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "nav";
    public static final String TITLE = "NavBar";


}
