package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Route(value = AnimalsView.ROUTE, layout= MainLayout.class)

public class AnimalsView extends VerticalLayout {

    public static final String ROUTE = "animals";
    public static final String TITLE = "Animals";

    public AnimalsView(AnimalRepo animalRepo) {

        setSizeFull();
        setPadding(true);

        List<Animal> animals = animalRepo.findAll();

        FlexLayout container = new FlexLayout();
        container.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        container.setJustifyContentMode(JustifyContentMode.CENTER);
        //create card for all animals
        for (Animal animal : animals) {
            container.add(createAnimalCard(animal)); //call create method
        }
        add(container);
    }


    private Component createAnimalCard(Animal animal) {
        Card imageCard = new Card();
        DownloadHandler imageHandler = DownloadHandler.forClassResource(
                getClass(), animal.getImageUrl(), "Animal Pic");
        Image image = new Image(imageHandler, "");
        image.setWidth("100px");

        H3 title = new H3(animal.getName());
        VerticalLayout layout = getVerticalLayout(animal, title, image);
        layout.addClassName("pet-card");

        return layout;
    }

    @NotNull
    private static VerticalLayout getVerticalLayout(Animal animal, H3 title, Image image) {
        UnorderedList details = new UnorderedList(
          new ListItem( "Name: " + animal.getName()),
                  new ListItem("Category: " + animal.getType() ),
                  new ListItem("Aggression: " + (animal.getAggression() ? "Yes, approach with caution" : "No"))
        );

        Button addNewAnimal = new Button("Add New Animal");

        VerticalLayout layout = new VerticalLayout(image, title, details);

        layout.setWidth("260px");
        layout.setPadding(true);
        layout.setSpacing(true);
        return layout;
    }
}
