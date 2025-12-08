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
import org.vaadin.crudui.crud.impl.GridCrud;


@CssImport("./styles/styles.css")
@Route(value= AllAnimalsView.ROUTE, layout = MainView.class)
public class AllAnimalsView extends VerticalLayout {
    public static final String ROUTE = "allAnimals";

    private final AnimalController animalController;
    private final GridCrud<Animal> crud;
    TextField searchTerm = new TextField();

    @Autowired
    public AllAnimalsView(AnimalController animalController) {

        this.animalController = animalController;
        crud = new GridCrud<>(Animal.class);

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
         //search Logic
        searchTerm.setValueChangeMode(ValueChangeMode.EAGER);
        searchTerm.addValueChangeListener(e -> {
            String value = e.getValue();
            crud.getGrid().setItems(animalController.findByAnimalNameContainingIgnoreCase(value));
        });

        // CRUD operations
        crud.setAddOperation(animalController::add);
        crud.setUpdateOperation(animalController::update);
        crud.setDeleteOperation(animalController::delete);
        crud.setFindAllOperation(animalController::findAll);

        add(searchTerm,crud);
        setSizeFull();
    }

}


//