package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;

import java.util.List;

@Route(value= CatsView.ROUTE, layout = MainView.class)
public class CatsView extends Div {
    public static final String ROUTE = "cats";

    public CatsView(AnimalRepo animalRepo) {
        Div catLayout = new Div();
        H1 h1 = new H1("Facility Housed Cats");
        catLayout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em")
                .set("margin", "2em");
        //getAll Data
        List<Animal> animals = animalRepo.findAll();

        //Create Cards
        for (Animal animal : animals) {
            if("Cat".equals(animal.getType())) {
                catLayout.add(createAnimalCard(animal));
            }
            add(h1, catLayout);
        }

    }
    private Component createAnimalCard(Animal animal) {
        Card catCard = new Card();
        catCard.addThemeVariants(CardVariant.LUMO_OUTLINED);

        DownloadHandler imageHandler = DownloadHandler.forClassResource(
                getClass(), animal.getImageUrl(), "Animal Pic");
        Image image = new Image(imageHandler, "");
        image.setWidth("100px");
        image.setHeight("100px");

        catCard.setTitle(new Div(animal.getName() + " • "+ animal.getType()));

        if(animal.isAggressive() == true){
            catCard.addThemeVariants(CardVariant.LUMO_OUTLINED);
            catCard.addClassName("aggression-card");
        }
        UnorderedList details = new UnorderedList(
                // new ListItem("Name: " + animal.getName()),
                new ListItem("Age: " + animal.getAge()),
                new ListItem("Aggression: " + (animal.isAggressive() ? "Yes" : "No"))
        );
        catCard.add(image, details);
        // Edit button
        Button editBtn = new Button("Edit", VaadinIcon.EDIT.create());
        editBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        catCard.addToFooter(editBtn);
        return catCard;
    }
}