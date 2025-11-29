package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;

import java.util.List;


@Route(value= DogsView.ROUTE, layout = MainView.class)
public class DogsView extends VerticalLayout {
    public static final String ROUTE = "dogs";
   // public static final String TITLE = "Dogs";

    public DogsView(AnimalRepo animalRepo) {
        Div dogLayout = new Div();
        dogLayout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em");

        setSizeFull();
        setPadding(true);

        List<Animal> animals = animalRepo.findAll();

        FlexLayout container = new FlexLayout();
        container.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        container.setJustifyContentMode(JustifyContentMode.CENTER);
        for (Animal animal : animals) {
            if("Dog".equals(animal.getType())) {
               container.add(createAnimalCard(animal));
            }
            add(container);
        }

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
