package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value= AnimalMedView.ROUTE, layout = MainView.class)
public class AnimalMedView extends VerticalLayout {
    public static final String ROUTE = "AnimalMed";
    private final AnimalController animalController;
    private final GridCrud<Animal> crud;
    TextField searchTerm = new TextField();

    @Autowired
    public AnimalMedView(AnimalController animalController) {
        this.animalController = animalController;
       H1 title = new H1("Health Records");
        crud = new GridCrud<>(Animal.class);
        crud.getGrid().removeAllColumns();
        crud.getGrid().addColumn(Animal::getAnimalName).setHeader("Name").setSortable(true);
        crud.getGrid().addColumn(Animal::getSpecies).setHeader("Species").setSortable(true);
       // crud.getGrid().addColumn(Animal::getTemperature).setHeader("Temperature").setSortable(true);
        crud.getGrid().addColumn(person ->
                (person.getTemperature() ==null) ? "Not Taken" : (person.getTemperature())
        ).setHeader("Temperature").setSortable(true);
        crud.getGrid().addColumn(person ->
                person.isBleeding() ? "Yes" : "No"
        ).setHeader("Bleeding").setSortable(true);

        crud.getGrid().addColumn(person ->
                person.isBrokenBones() ? "Yes" : "No"
        ).setHeader("Broken Bones").setSortable(true);;

        crud.getGrid().addColumn(person ->
                person.isUnableToWalk() ? "Yes" : "No"
        ).setHeader("Walking Impaired").setSortable(true);;

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

        add(title,searchTerm,crud);
        setSizeFull();
    }
}
