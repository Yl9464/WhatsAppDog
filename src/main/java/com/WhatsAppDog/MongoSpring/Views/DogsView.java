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


@Route(value= DogsView.ROUTE, layout = MainView.class)

public class DogsView extends Div {
    public static final String ROUTE = "dogs";

    public DogsView(AnimalRepo animalRepo) {
        Div dogLayout = new Div();
        H1 h1 = new H1("Facility Housed Dogs");
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
           add(h1, dogLayout);
        }
        //add button
//        Button addCard = new Button("Add");
//        addCard.addClickListener(event -> {
//            Div newCard = createAnimalCard("Name", "Age", "Agression");
//
//        });
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

//private Div newCard(String name, Integer age, Boolean aggression) {
//        Div dogCard = new Div();
//   dogCard.getStyle().set("border", "1px solid #ccc");
//   dogCard.getStyle().set("border-radius", "8px");
//   dogCard.getStyle().set("padding", "16px");
//   dogCard.getStyle().set("width", "200px");
//   dogCard.getStyle().set("box-shadow", "2px 2px 6px rgba(0,0,0,0.1)");
//
//    Label title = new Label(name);
//    Label dogAge = new Label(String.valueOf(age));
//    Label aggressionStatus = new Label(String.valueOf(aggression));
//
//    dogCard.add(title, dogAge, aggressionStatus);
//    return dogCard;

}

