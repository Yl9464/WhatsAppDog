package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalIntakeController;
import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="intakeForm")
public class AnimalIntakeForm extends FormLayout {

    private AnimalIntakeController animalIntakeController; // service autowired

    @Autowired
    public AnimalIntakeForm( AnimalIntakeController animalIntakeController) {
        this.animalIntakeController = animalIntakeController;
        //Fields
        TextField animalId = new TextField("Animal ID");
        TextField animalName = new TextField("Animal Name");
        TextField species = new TextField("Species");
        TextField breed = new TextField("Breed" );
        TextField color = new TextField("Color");

        ComboBox<String> intakeType = new ComboBox<>("Intake Type");
        intakeType.setItems("Stray", "Owner Surrender", "Transfer", "Court Order");

        Checkbox medicalRecords = new Checkbox("Medical Records?");
        TextField staffInitials = new TextField("Staff Initials");
        NumberField temperature = new NumberField("Temperature");
        Checkbox unableToWalk = new Checkbox("Unable to walk");
        Checkbox troubleBreathing = new Checkbox("Trouble breathing");
        Checkbox bleeding = new Checkbox ("Bleeding");
        Checkbox brokenBones = new Checkbox("Broken bones");

        Binder<AnimalIntake> binder = new Binder<> (AnimalIntake.class);
        add(animalId,animalName,species,breed,color,intakeType,medicalRecords,staffInitials,temperature,unableToWalk,troubleBreathing,bleeding,brokenBones);
      //bind fields
        binder.forField(temperature)
                .withConverter(
                        value -> value,        // NumberField gives Double, model wants Double
                        value -> value
                )
                .bind(AnimalIntake::getTemperature, AnimalIntake::setTemperature);
        binder.forField(medicalRecords)
                .bind(AnimalIntake::isMedicalRecords, AnimalIntake::setMedicalRecords);

        // Save button
        Button saveButton = new Button("Save", e -> {
            AnimalIntake animal = binder.getBean();
            animalIntakeController.save(animal); // use Autowired service
        });

        add(saveButton);
    }
}
