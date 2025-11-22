package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.io.Serial;
import java.util.List;

@Route(value = AnimalsView.ROUTE, layout= MainLayout.class)
public class AnimalsView extends VerticalLayout {

    public static final String ROUTE = "animals";
    public static final String TITLE = "Animals";

public AnimalsView(AnimalRepo animalRepo) {
    H1 h1 = new H1("In House Animals");
    Grid<Animal> grid = new Grid<>(Animal.class, false);
    grid.addColumn(Animal::getName).setHeader("Name");
    grid.addColumn(Animal::getType).setHeader("Type");
    grid.addColumn(Animal::getAge).setHeader("Age");
    grid.addColumn(Animal::getAggression).setHeader("Aggression");

    List<Animal> animal = animalRepo.findAll();
    grid.setItems(animal);
    add(h1,grid);
    }

//    private void createComboBoxes() {
//        ComboBox<String> normalCombo = new ComboBox<>();
//        normalCombo.setItems("First", "Second", "Third");
//
//        ComboBox<String> yellowBgColorCombo = new ComboBox<>();
//        yellowBgColorCombo.setItems("First", "Second", "Third");
//        yellowBgColorCombo.setClassName("yellowBg");
//        yellowBgColorCombo.setOverlayClassName("yellowBg");
//
//        add(new HorizontalLayout(normalCombo, yellowBgColorCombo));
//    }
//
//    private void createExampleTextSpan() {
//        Span span = new Span("This is example text");
//
//        span.addClassNames(
//                LumoUtility.FontSize.LARGE,
//                LumoUtility.FontWeight.BOLD,
//                LumoUtility.Border.ALL,
//                LumoUtility.BorderRadius.MEDIUM,
//                LumoUtility.BorderColor.ERROR,
//                LumoUtility.Margin.Top.LARGE,
//                LumoUtility.Padding.MEDIUM
//        );
//
//        add(span);
//    }
}
