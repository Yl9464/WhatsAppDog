package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalIntakeController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="intakeForm")
public class AnimalIntakeForm extends VerticalLayout {

    private  AnimalIntakeController animalIntakeController;
    //private final Binder<AnimalIntake> binder = new Binder<>(AnimalIntake.class);

    @Autowired
    public AnimalIntakeForm() {
       // setSizeFull();
        setWidth(null);
        setPadding(true);
        setSpacing(true);
        //setHeightFull();
        addClassName("intakeForm");
        //HorizontalLayout animalInfo = new HorizontalLayout();
        H1 title = new H1("Intake Form");
        title.addClassName("intakeTitle");
add(title);
        configAnimalInfo();
        configMedInfo();
;
        // Save button
        Button saveButton = new Button("Save", e -> {
            //AnimalIntake animal = binder.getBean();
            //animalIntakeController.save(animal); // use Autowired service
        });
        add(saveButton);

//        Binder<AnimalIntake> binder = new Binder<>(AnimalIntake.class);
//        add(animalId,animalName,species,breed,color,intakeType,medicalRecords,staffInitials,temperature,unableToWalk,troubleBreathing,bleeding,brokenBones);
//        //bind fields
//        binder.forField(temperature)
//                .withConverter(
//                        value -> value,        // NumberField gives Double, model wants Double
//                        value -> value
//                )
//                .bind(AnimalIntake::getTemperature, AnimalIntake::setTemperature);
//        binder.forField(medicalRecords)
//                .bind(AnimalIntake::isMedicalRecords, AnimalIntake::setMedicalRecords);


    }

    private void configMedInfo() {
        Checkbox medicalRecords = new Checkbox("Medical Records?");
        //
        HorizontalLayout walkBreath = new HorizontalLayout();
        Checkbox unableToWalk = new Checkbox("Unable to walk");
        Checkbox troubleBreathing = new Checkbox("Trouble breathing");
        walkBreath.add(unableToWalk,troubleBreathing);

        //
       HorizontalLayout bleedBones = new HorizontalLayout();
        Checkbox bleeding = new Checkbox ("Bleeding");
        Checkbox brokenBones = new Checkbox("Broken bones");
       bleedBones.add(bleeding,  brokenBones);

        //
        HorizontalLayout initialsTemp = new HorizontalLayout();
        NumberField temperature = new NumberField("Temperature");
        TextField staffInitials = new TextField("Staff Initials");
        initialsTemp.add(temperature,staffInitials);
        //spacing
        walkBreath.expand(initialsTemp);
       add(new H3("Medical Information"),medicalRecords, walkBreath,bleedBones,initialsTemp);
    }

    private void configAnimalInfo() {
        //Fields
        HorizontalLayout idType = new HorizontalLayout();
        TextField animalId = new TextField("Animal ID");
        ComboBox<String> intakeType = new ComboBox<>("Intake Type");
        intakeType.setItems("Stray", "Owner Surrender", "Transfer", "Court Order");
        idType.add(animalId, intakeType);

//
        HorizontalLayout nameSpecies = new HorizontalLayout();
        TextField animalName = new TextField("Name" );
        TextField species = new TextField("Species");
        nameSpecies.add(animalName,species);
        //
        HorizontalLayout breedColor = new HorizontalLayout();
        TextField breed = new TextField("Breed" );
        TextField color = new TextField("Color");
        breedColor.add(breed,color);
        add(new H3("Animal Information"), idType, nameSpecies, breedColor);
    }
}
