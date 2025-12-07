package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalIntakeController;
import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="intakeForm")
public class AnimalIntakeForm extends VerticalLayout {

    private final AnimalIntakeController animalIntakeController;
    private final Binder<AnimalIntake> binder = new Binder<>(AnimalIntake.class);

    @Autowired
    public AnimalIntakeForm(AnimalIntakeController animalIntakeController) {
        this.animalIntakeController = animalIntakeController;

        // ----- PAGE TITLE -----
        H1 pageTitle = new H1("Animal Intake Form");
        pageTitle.getStyle()
                .set("text-align", "center")
                .set("margin", "0")
                .set("padding", "0 0 20px 0")
                .set("font-weight", "600");

        // You MUST add the title before the container
        add(pageTitle);

        // ----- LEFT FORM -----
        FormLayout leftForm = new FormLayout();
        leftForm.setWidthFull();
        addClassName("left-form-padding");

        leftForm.add(
                new H2("Animal Information"),
                new TextField("Animal ID"),
                new TextField("Animal Name"),
                new TextField("Species"),
                new TextField("Breed")
        );

        // ----- RIGHT FORM -----
        FormLayout rightForm = new FormLayout();
        rightForm.setWidthFull();

        rightForm.add(
                new H2("Medical Information"),
                new Checkbox("Unable to walk"),
                new Checkbox("Trouble breathing"),
                new Checkbox("Bleeding"),
                new TextField("Temperature")
        );

        // ----- WRAPPERS FOR CORRECT SIZING -----
        Div leftWrapper = new Div(leftForm);
        leftWrapper.addClassName("left-side");

        Div rightWrapper = new Div(rightForm);
        rightWrapper.addClassName("right-side");

        leftWrapper.setWidthFull();
        rightWrapper.setWidthFull();

        // ----- SPLIT LAYOUT -----
        HorizontalLayout container = new HorizontalLayout(leftWrapper, rightWrapper);
        container.setWidthFull();
        container.setSpacing(true);
        container.setPadding(true);
        container.setMargin(true);
        container.setFlexGrow(1, leftWrapper);
        container.setFlexGrow(1, rightWrapper);

        // Add the split form below the title
        add(container);
    }
}
