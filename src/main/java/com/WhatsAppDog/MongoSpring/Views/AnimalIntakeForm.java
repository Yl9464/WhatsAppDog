package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.AnimalController;
import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class AnimalIntakeForm extends VerticalLayout {
   private AnimalController animalController;

    TextField animalId = new TextField("Animal ID");
    ComboBox<String> intakeType = new ComboBox<>("Intake Type");
    TextField animalName = new TextField("Name");
    TextField species = new TextField("Species");
    TextField breed = new TextField("Breed");
    TextField color = new TextField("Color");
    //medfields
    Checkbox medicalRecords = new Checkbox("Medical Records");
    Checkbox unableToWalk = new Checkbox("Unable to walk");
    Checkbox troubleBreathing = new Checkbox("Trouble breathing");
    Checkbox bleeding = new Checkbox("Bleeding");
    Checkbox brokenBones = new Checkbox("Broken bones");
    NumberField temperature = new NumberField("Temperature");
    TextField staffInitials = new TextField("Staff Initials");
    Button save = new Button("Save");
    Binder<AnimalIntake> binder = new Binder<>(AnimalIntake.class);

    @Autowired
    public AnimalIntakeForm(AnimalController animalController) {
        this.animalController = animalController; //controller injected
        // setSizeFull();
        setWidth(null);
        setPadding(true);
        setSpacing(true);
        addClassName("intakeForm");

        H1 title = new H1("Intake Form");
        title.addClassName("intakeTitle");
        add(title);

        //add UI fields

        //animal profile
        intakeType.setItems("Stray", "Owner Surrender", "Transfer", "Court Order");
        HorizontalLayout idType = new HorizontalLayout();
        HorizontalLayout nameSpecies = new HorizontalLayout();
        HorizontalLayout breedColor = new HorizontalLayout();
        idType.add(animalId, intakeType);
        nameSpecies.add(animalName,species);
        breedColor.add(breed,color);
        add(new H3("Animal Information"), idType, nameSpecies, breedColor);
       //med rec
        HorizontalLayout walkBreath = new HorizontalLayout();
        HorizontalLayout bleedBones = new HorizontalLayout();
        HorizontalLayout initialsTemp = new HorizontalLayout();
        walkBreath.add(unableToWalk, troubleBreathing);
         bleedBones.add(bleeding, brokenBones);
        initialsTemp.add(temperature, staffInitials);
        add(new H3("Medical Information"), medicalRecords, walkBreath, bleedBones, initialsTemp);


        binder.bindInstanceFields(this);     // bind UI fields to AnimalIntake model
        binder.setBean(new AnimalIntake());// start with empty object

        //save
        add(save);
        save.addClickListener(event -> {
            //get data
            //AnimalIntake animalIntake = binder.getBean();

            //map to existing db
            Animal animal = new Animal();
            animal.setAnimalName(binder.getBean().getAnimalName());
            animal.setSpecies(binder.getBean().getSpecies());
            animal.setBreed(binder.getBean().getBreed());
            animal.setColor(binder.getBean().getColor());
            animal.setIntakeType(binder.getBean().getIntakeType());
            animal.setMedicalRecords(binder.getBean().isMedicalRecords());
            animal.setStaffInitials(binder.getBean().getStaffInitials());
            animal.setTemperature(binder.getBean().getTemperature());
            animal.setUnableToWalk(binder.getBean().isUnableToWalk());
            animal.setTroubleBreathing(binder.getBean().isTroubleBreathing());
            animal.setBleeding(binder.getBean().isBleeding());
            animal.setBrokenBones(binder.getBean().isBrokenBones());
            //save to db
            animalController.add(animal);
            Notification.show("Animal Saved Successfully");
            //clear form
            binder.setBean(new AnimalIntake());

            /// /
//           animalIntakeController.saveAnimal(binder.getBean());
//            Notification.show("Animal Saved");
//            binder.setBean(new AnimalIntake());//clear fields
        });


    }
}

//    private void configMedInfo() {
//
//        HorizontalLayout walkBreath = new HorizontalLayout();
//        walkBreath.add(unableToWalk, troubleBreathing);
//        //////////
//        HorizontalLayout bleedBones = new HorizontalLayout();
//        bleedBones.add(bleeding, brokenBones);
//        //////////
//        HorizontalLayout initialsTemp = new HorizontalLayout();
//        initialsTemp.add(temperature, staffInitials);
//        //save input data
//        binder.bindInstanceFields(this);
//        saveBtn.addClickListener(e -> saveAnimal());
//        add(new H3("Medical Information"), medicalRecords, walkBreath, bleedBones, initialsTemp);
//    }


//    private void configAnimalInfo() {
//        //Fields
//
//        intakeType.setItems("Stray", "Owner Surrender", "Transfer", "Court Order");
//        HorizontalLayout idType = new HorizontalLayout();
//        idType.add(animalId, intakeType);
//        /// //
//        HorizontalLayout nameSpecies = new HorizontalLayout();
//        nameSpecies.add(animalName,species);
//        ///// //
//        HorizontalLayout breedColor = new HorizontalLayout();
//        breedColor.add(breed,color);
//
//        //save input data
//       binder.bindInstanceFields(this);
//      saveBtn.addClickListener(e -> saveAnimal());
//        add(new H3("Animal Information"), idType, nameSpecies, breedColor);
//    }
//    private void saveAnimal() {
//        AnimalIntake animal = new AnimalIntake();
//        try {
//            binder.writeBean(animal);
//            intakeRepo.save(animal);
//            Notification.show("Animal saved!");
//            binder.readBean(new AnimalIntake()); // reset form
//        } catch (Exception e) {
//            Notification.show("Error saving animal: " + e.getMessage());
//        }
//
//    }
//}
