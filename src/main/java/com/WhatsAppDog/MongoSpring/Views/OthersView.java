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


@Route(value= OthersView.ROUTE, layout = MainView.class)
    public class OthersView extends Div {
        public static final String ROUTE = "others";

        public OthersView(AnimalRepo animalRepo) {
            Div otherLayout = new Div();
            otherLayout.getStyle().set("display", "grid")
                    .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                    .set("gap", "1em")
                    .set("margin", "2em");
            //getAll Data
            List<Animal> animals = animalRepo.findAll();

            //Create Cards
            for (Animal animal : animals) {
                if((!"Cat".equals(animal.getType())) && (!"Dog".equals(animal.getType())) ) {
                       otherLayout.add(createAnimalCard(animal));
                }
                add(otherLayout);
            }
        }
    private Component createAnimalCard(Animal animal) {
        Card othersCard = new Card();
        othersCard.addThemeVariants(CardVariant.LUMO_OUTLINED);

        DownloadHandler imageHandler = DownloadHandler.forClassResource(
                getClass(), animal.getImageUrl(), "Animal Pic");
        Image image = new Image(imageHandler, "");
        image.setWidth("100px");
        image.setHeight("100px");

        othersCard.setTitle(new Div(animal.getName() + " • "+ animal.getType()));
        if(animal.getAggression() == true){
           othersCard.addThemeVariants(CardVariant.LUMO_OUTLINED);
           othersCard.addClassName("aggression-card");
        }

        UnorderedList details = new UnorderedList(
                // new ListItem("Name: " + animal.getName()),
                new ListItem("Age: " + animal.getAge()),
                new ListItem("Aggression: " + (animal.getAggression() ? "Yes" : "No"))
        );
        othersCard.add(image, details);
        // Edit button
        Button editBtn = new Button("Edit", VaadinIcon.EDIT.create());
        editBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        othersCard.addToFooter(editBtn);

        return othersCard;
    }
}