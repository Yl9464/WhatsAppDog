package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalIntakeController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;


@CssImport("./styles/styles.css")
@Route(value= AllAnimalsView.ROUTE, layout = MainView.class)

public class AllAnimalsView extends VerticalLayout {
    public static final String ROUTE = "allAnimals";

   private final AnimalIntakeController intakeController;

    private final GridCrud<AnimalIntake> crud;

    @Autowired
    public AllAnimalsView(AnimalIntakeController intakeController) {

        this.intakeController = intakeController;
//search

        TextField searchField = new TextField();
        searchField.setPlaceholder("Name...");
        searchField.setClearButtonVisible(true);
        searchField.setWidth("300px");


        add(searchField);

        //set grid
        crud = new GridCrud<>(AnimalIntake.class);
        crud.setCrudListener(new CrudListener<AnimalIntake>() {
            @Override
            public Collection<AnimalIntake> findAll() {
                return intakeController.findAll();
            }

            @Override
            public AnimalIntake add(AnimalIntake animal) {
                return intakeController.saveAnimal(animal);
            }

            @Override
            public AnimalIntake update(AnimalIntake animal) {
                return intakeController.saveAnimal(animal);
            }

            @Override
            public void delete(AnimalIntake animal) {
                intakeController.delete(animal);
            }
        });
        crud.getGrid().removeAllColumns();
        crud.getGrid().addColumn(AnimalIntake::getAnimalName).setHeader("Name").setSortable(true);
        crud.getGrid().addColumn(AnimalIntake::getSpecies).setHeader("Species").setSortable(true);
        crud.getGrid().addColumn(AnimalIntake::getBreed).setHeader("Breed").setSortable(true);
        crud.getGrid().addColumn(AnimalIntake::getColor).setHeader("Color").setSortable(true);
        crud.getGrid().addColumn(AnimalIntake::getIntakeType).setHeader("Intake Type").setSortable(true);

        add(crud);
        setSizeFull();
    }

}


