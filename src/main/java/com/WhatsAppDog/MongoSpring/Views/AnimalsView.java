package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.UI;

import java.util.List;

@Route(value = AnimalsView.ROUTE, layout= MainView.class)

public class AnimalsView extends Div {

    public static final String ROUTE = "animals";
    public static final String TITLE = "Animals";

    public AnimalsView(AnimalRepo animalRepo) {
        Div layout = new Div();
        layout.getStyle().set("display", "grid")
                .set("grid-template-columns", "repeat(auto-fill, minmax(190px, 1fr))")
                .set("gap", "1em");

        List<Animal> animals = animalRepo.findAll();
        //create card for dog cards
        for (Animal animal : animals) {
            //if animal category = dog  render cards in DogsView
            if("Dog".equals(animal.getType())) {
                UI.getCurrent().getNavigator().navigateTo(DogsView.ROUTE + "/" + animal.getType());
            }
            if("Cat".equals(animal.getType())) {
                UI.getCurrent().getNavigator().navigateTo(CatsView.ROUTE + "/" + animal.getType());
            }
            else{
                UI.getCurrent().getNavigator().navigateTo(OthersView.ROUTE + "/" + animal.getType());
            }
        }
        add(layout);
    }


}