package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Route(value = "", layout = MainView.class)

public class HomeView extends VerticalLayout {
    public static final String ROUTE = "home";
    public static final String TITLE = "Home";

    public HomeView() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"); // Customize format
        String formattedDate = currentDate.format(formatter);

        //Span dateSpan = new Span("Today's Date: " + formattedDate);
        AnimalIntakeForm intakeForm = new AnimalIntakeForm();

        add(formattedDate);
        add(intakeForm);

    }

}