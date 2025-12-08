package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;


@CssImport("./styles/styles.css")
@Route(value= AllAnimalsView.ROUTE, layout = MainView.class)

public class AllAnimalsView extends VerticalLayout {
    public static final String ROUTE = "allAnimals";

    //private final AnimalIntakeController intakeController;
    private final AnimalController animalController;
    private final GridCrud<Animal> crud;
    TextField searchTerm = new TextField();

    @Autowired
    public AllAnimalsView(AnimalController animalController) {

        this.animalController = animalController;
        crud = new GridCrud<>(Animal.class);
        crud.setCrudListener(new CrudListener<Animal>() {
            @Override
            public Collection<Animal> findAll() {
                return animalController.findAll();
            }

            @Override
            public Animal add(Animal animal) {
                return animalController.add(animal);
            }

            @Override
            public Animal update(Animal animal) {
                return animalController.update(animal);
            }

            @Override
            public void delete(Animal animal) {
                animalController.delete(animal);
            }
        });


        crud.getGrid().removeAllColumns();
        crud.getGrid().addColumn(Animal::getAnimalName).setHeader("Name").setSortable(true);
        crud.getGrid().addColumn(Animal::getSpecies).setHeader("Species").setSortable(true);
        crud.getGrid().addColumn(Animal::getBreed).setHeader("Breed").setSortable(true);
        crud.getGrid().addColumn(Animal::getColor).setHeader("Color").setSortable(true);
        crud.getGrid().addColumn(Animal::getIntakeType).setHeader("Intake Type").setSortable(true);
        //search bar
        searchTerm.setPlaceholder("Enter name...");
        searchTerm.setClearButtonVisible(true);
        searchTerm.setWidth("300px");
        add(searchTerm);

         //search Logic
        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        add(crud);
        setSizeFull();
    }

}


//