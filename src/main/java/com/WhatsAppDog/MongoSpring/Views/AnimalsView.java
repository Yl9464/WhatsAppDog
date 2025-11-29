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

      //  animals.stream().filter(a -> a.name()).forEach(a -> layout.add(createAnimalCard(a));
        //create card for all animals
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
            //if ....            = cat render cards in CatsView
            //else render cards in OthersView
           // layout.add(createAnimalCard(animal)); //call create method
        }
        add(layout);
    }


////    private Component createAnimalCard(Animal animal) {
//        Card cardOutlined = new Card();
//        cardOutlined.addThemeVariants(CardVariant.LUMO_OUTLINED);
//
//        DownloadHandler imageHandler = DownloadHandler.forClassResource(
//                getClass(), animal.getImageUrl(), "Animal Pic");
//        Image image = new Image(imageHandler, "");
//        image.setWidth("100px");
//        image.setHeight("100px");
//
//        UnorderedList details = new UnorderedList(
//                new ListItem("Name: " + animal.getName()),
//                new ListItem("Category: " + animal.getType()),
//                new ListItem("Aggression: " + (animal.getAggression() ? "Yes, approach with caution" : "No"))
//        );
//        cardOutlined.add(image, details);
//
//        return cardOutlined;
//    }
}