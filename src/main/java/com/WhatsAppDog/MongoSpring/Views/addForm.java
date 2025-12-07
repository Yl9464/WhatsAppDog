package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.function.Consumer;

public class addForm extends Dialog {
     TextField name = new TextField("Name");
     TextField type = new TextField("Type");
        NumberField age = new NumberField("Age");

     Button save = new Button("Save");
     Button cancel = new Button("Cancel");

    private Animal current;
    private Consumer<Animal> saveListener;

    public addForm(Consumer<Animal> saveListener) {
        this.saveListener = saveListener;

        save.addClickListener(e -> save());
        cancel.addClickListener(e -> close());

        VerticalLayout layout = new VerticalLayout(name, type, age, save, cancel);
        add(layout);
    }

    public void open(Animal animal) {
        this.current = animal;
        name.setValue(animal.getName() == null ? "" : animal.getName());
        type.setValue(animal.getType() == null ? "" : animal.getType());
        super.open();
    }

    private void save() {
        current.setName(name.getValue());
        current.setType(type.getValue());
        saveListener.accept(current);  // calls parent View's saveAnimal()
        close();
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