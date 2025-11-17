package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.io.Serial;

@Route(value = Buttons.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class Buttons extends VerticalLayout {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "Buttons";
    public static final String TITLE = "Buttons";

    public Buttons() {
        setSizeFull();

        add(new Span("Buttons"));
        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        //The default style is secondary
        Button secondaryButton = new Button("Secondary");
        Button tertiaryButton = new Button("Tertiary");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        tertiaryButton.getElement().getThemeList().add("tertiary");
        add(new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton));
    }
}

