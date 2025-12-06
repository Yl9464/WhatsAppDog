package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.function.Consumer;

public class addForm extends Dialog {

    private final Binder<Animal> binder = new Binder<>(Animal.class);

    public addForm(Consumer<Animal> onSave) {
      HorizontalLayout checkBoxes = new HorizontalLayout();
      checkBoxes.setSpacing(true);

        Checkbox isAggressive = new Checkbox("Check if there are known signs of aggression");
        Checkbox isFemale = new Checkbox("Check if female");
        checkBoxes.add(isFemale, isAggressive);
      FormLayout layout = new FormLayout();
        TextField name = new TextField("Enter name");
        TextField type = new TextField("Enter type of animal");
        NumberField age = new NumberField("Enter Age");
        layout.add(name, type, age, checkBoxes );

        binder.bindInstanceFields(this);

        Button save = new Button("Save");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickListener(e -> {
            if (binder.validate().isOk()) {
                Animal animal = binder.getBean();
                onSave.accept(animal);
                close();
                Notification.show("Saved");
            } else {
                Notification.show("Fix errors");
            }
        });

        Button cancel = new Button("Cancel");
        cancel.addClickListener(e -> close());
        add(layout, save, cancel);
    }

    public void open(Animal animal) {
        binder.setBean(animal);
        super.open();
    }
}

//Staff Form
//TextField firstName = new TextField("First Name");
////    TextField lastName = new TextField("Last Name");
////    Checkbox isEmployee = new Checkbox("Are you an employee?");
//    NumberField salary = new NumberField("Salary");
//
//    Button save =  new Button("Save");
//
//    Binder<Staff> binder = new Binder<>(Staff.class);
//
//    public addForm(){
//        add(firstName, lastName, isEmployee, salary, save);
//        binder.bindInstanceFields(this);
//
//    }
//
//    public void setStaff(Staff staff){
//        binder.setBean(staff);
//    }
//    public Button getSaveButton() {
//        return save;
//    }
//
//    public Staff getCurrentStaff() {
//        return binder.getBean();
//    }