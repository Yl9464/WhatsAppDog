package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainLayout;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;

@Route(value = AnimalsView.ROUTE, layout= MainLayout.class)

public class AnimalsView extends Div {

    public static final String ROUTE = "animals";
    public static final String TITLE = "Animals";

    public AnimalsView(AnimalRepo animalRepo) {
        Div layout = new Div();
        layout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em");

        Card imageCard = new Card();
        DownloadHandler imageHandler = DownloadHandler.forClassResource(
                getClass(), "images/tempAnimal.png", "Animal Pic Placeholder");
        Image image = new Image(imageHandler, "");
        image.setWidth("100px");
        imageCard.setMedia(image);
        imageCard.add("Lapland is the northern-most region of Finland and an active outdoor destination.");

        layout.add(imageCard);
        add(layout);
    }
}
//Grid data rendering
//public class AnimalsView extends VerticalLayout{
//H1 h1 = new H1("In House Animals");
//    Grid<Animal> grid = new Grid<>(Animal.class, false);
//    grid.addColumn(Animal::getName).setHeader("Name");
//    grid.addColumn(Animal::getType).setHeader("Type");
//    grid.addColumn(Animal::getAge).setHeader("Age");
//    grid.addColumn(Animal::getAggression).setHeader("Aggression");
//
//    List<Animal> animal = animalRepo.findAll();
//    grid.setItems(animal);
//    add(h1,grid);
//