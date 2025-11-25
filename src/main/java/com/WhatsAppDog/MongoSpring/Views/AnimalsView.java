package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Route(value = AnimalsView.ROUTE, layout= MainLayout.class)

public class AnimalsView extends Div {

    public static final String ROUTE = "animals";
    public static final String TITLE = "Animals";

    public AnimalsView(AnimalRepo animalRepo) {
        Div layout = new Div();
        layout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em");

        List<Animal> animals = animalRepo.findAll();

        //create card for all animals
        for (Animal animal : animals) {
            layout.add(createAnimalCard(animal)); //call create method
        }
        add(layout);
    }


    private Component createAnimalCard(Animal animal) {
        Card cardOutlined = new Card();
        cardOutlined.addThemeVariants(CardVariant.LUMO_OUTLINED);

        DownloadHandler imageHandler = DownloadHandler.forClassResource(
                getClass(), animal.getImageUrl(), "Animal Pic");
        Image image = new Image(imageHandler, "");
        image.setWidth("100px");
        image.setHeight("100px");

        UnorderedList details = new UnorderedList(
                new ListItem("Name: " + animal.getName()),
                new ListItem("Category: " + animal.getType()),
                new ListItem("Aggression: " + (animal.getAggression() ? "Yes, approach with caution" : "No"))
        );
        cardOutlined.add(image, details);

        return cardOutlined;
    }
}