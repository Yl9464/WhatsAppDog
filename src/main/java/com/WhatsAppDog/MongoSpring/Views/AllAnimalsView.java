package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;


@CssImport("./styles/styles.css")
@Route(value= AllAnimalsView.ROUTE, layout = MainView.class)

public class AllAnimalsView extends VerticalLayout {
    public static final String ROUTE = "allAnimals";


    private  AllAnimalsView animalRepo;

    @Autowired
    public AllAnimalsView(AnimalController animalController){
        GridCrud<Animal> animalCrud = new GridCrud<>(Animal.class, animalController);

        Grid<Animal> animalGrid = animalCrud.getGrid();
        animalGrid.removeAllColumns();
        animalGrid.addColumn(Animal::getType).setHeader("Category").setSortable(true);
        animalGrid.addColumn(Animal::getName).setHeader("Name").setSortable(true);
        animalGrid.addColumn(Animal::getAge).setHeader("Age").setSortable(true);
        animalGrid.addColumn(animal -> animal.isFemale() ? "Female" : "Male").setHeader("Gender").setSortable(true);
        animalGrid.addComponentColumn(animal -> {
            Span badge = new Span(animal.isAggressive() ? "Aggressive" : "None");
            if(animal.isAggressive()){ badge.getElement().getStyle().set("color", "red");};
            return badge;
        }).setHeader("Aggression Status").setSortable(true);

        animalGrid.addComponentColumn(animal -> {
            Button delete = new Button("Delete");
            delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

            delete.addClickListener(e -> {
                animalController.delete(animal);
                animalCrud.refreshGrid();
                Notification.show("Deleted " + animal.getName());
            });
            return delete;
        }).setHeader("Delete");


        add(animalCrud);
        setSizeFull();
    }

}
