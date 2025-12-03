package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;

import java.util.List;


@Route(value= DogsView.ROUTE, layout = MainView.class)

public class DogsView extends Div {
    public static final String ROUTE = "dogs";

    public DogsView(AnimalRepo animalRepo) {
        Div dogLayout = new Div();
        dogLayout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em")
                .set("margin", "2em");
        //getAll Data
        List<Animal> animals = animalRepo.findAll();

        //Create dog Cards
        for (Animal animal : animals) {
            if("Dog".equals(animal.getType())) {
                dogLayout.add(createAnimalCard(animal));
            }
            add(dogLayout);
        }

    }

    private Component createAnimalCard(Animal animal) {
        Card dogCard = new Card();
        dogCard.addThemeVariants(CardVariant.LUMO_OUTLINED);

        DownloadHandler imageHandler = DownloadHandler.forClassResource(
                getClass(), animal.getImageUrl(), "Animal Pic");
        Image image = new Image(imageHandler, "");
        image.setWidth("100px");
        image.setHeight("100px");

        dogCard.setTitle(new Div(animal.getName() + " • "+ animal.getType()));

        if(animal.getAggression() == true){
            dogCard.addThemeVariants(CardVariant.LUMO_OUTLINED);
            dogCard.addClassName("aggression-card");
        }
        UnorderedList details = new UnorderedList(
                // new ListItem("Name: " + animal.getName()),
                new ListItem("Age: " + animal.getAge()),
                new ListItem("Aggression: " + (animal.getAggression() ? "Yes" : "No"))
        );

        dogCard.add(image, details);
        // Edit button
        Button editBtn = new Button("Edit", VaadinIcon.EDIT.create());
        editBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        dogCard.addToFooter(editBtn);

        return dogCard;
    }

}