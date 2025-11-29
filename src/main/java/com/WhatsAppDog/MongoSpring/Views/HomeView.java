package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "", layout = MainView.class)

public class HomeView extends VerticalLayout {
    public static final String ROUTE = "home";
    public static final String TITLE = "Home";

    public HomeView() {
        H1 h1 = new H1("App Home Page");
        add(h1);
//        Button button = new Button("Click me");
//        DatePicker datePicker = new DatePicker("Pick a date");
//
//        HorizontalLayout dateLayout = new HorizontalLayout(button, datePicker);
//        dateLayout.setDefaultVerticalComponentAlignment(Alignment.END);
//        add(dateLayout);
//
//        button.addClickListener(click-> add(new Paragraph("Clicked: " + datePicker.getValue())));
    }

}