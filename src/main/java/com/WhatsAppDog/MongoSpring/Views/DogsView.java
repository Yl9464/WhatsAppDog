package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalController;
import com.WhatsAppDog.MongoSpring.MainView;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.List;

@Route(value= DogsView.ROUTE, layout = MainView.class)
public class DogsView extends VerticalLayout{
    public static final String ROUTE = "dogs";

    public DogsView(AnimalController animalController) {
        GridCrud<Animal> crud = new GridCrud<>(Animal.class);

        crud.setCrudListener(new CrudListener<Animal>() {
            @Override
            public List<Animal> findAll() {
                return animalController.findAll();
            }

            @Override
            public Animal add(Animal animal) {
                return animalController.add(animal);
            }

            @Override
            public Animal update(Animal animal) {
                return animalController.update(animal);
            }

            @Override
            public void delete(Animal animal) {
                animalController.delete(animal);
            }
        });
        //rmv default
        crud.getGrid().removeAllColumns();
        //add card render
        crud.getGrid().addColumn(new ComponentRenderer<>(animal -> {
            DownloadHandler imgHandler = DownloadHandler.forClassResource(
                    getClass(), animal.getImageUrl(), "Animal Pic"
            );
            Image img = new Image(imgHandler, "");
            img.setWidth("100px");
            img.setHeight("100px");


            HorizontalLayout card = new HorizontalLayout();
            card.getStyle().set("border", "1px solid #ccc");
            card.getStyle().set("padding", "14px");
            card.getStyle().set("border-radius", "10px");
            card.getStyle().set("box-shadow", "1px 3px 5px rgba(0,0,0,0.2)");
            //card.setWidth("300px");

            H4 name = new H4(animal.getName());
            Span age = new Span("Age: " + animal.getAge());
            Span aggression = new Span("Aggression: " + (animal.isAggressive() ? "Use caution" : "No"));
            Span image = new Span(animal.getImageUrl());
            Span gender = new Span(animal.isFemale() ? "Female" : "Male");

            card.add(img, name, age, aggression, gender);

            return card;
        }));
        crud.getGrid().setAllRowsVisible(true);
        add(new H2("Dog Cards"), crud);

        }
    }
