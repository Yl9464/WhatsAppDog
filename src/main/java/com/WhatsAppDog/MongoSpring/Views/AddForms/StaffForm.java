package com.WhatsAppDog.MongoSpring.Views.AddForms;

import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;

public class StaffForm extends FormLayout {
    TextField firstName = new TextField("First Name");
    TextField lastName = new TextField("Last Name");
    Checkbox isEmployee = new Checkbox("Are you an employee?");
    NumberField salary = new NumberField("Salary");

    Button save =  new Button("Save");

    Binder<Staff> binder = new Binder<>(Staff.class);

    public StaffForm(){
        add(firstName, lastName, isEmployee, salary, save);
        binder.bindInstanceFields(this);

    }

    public void setStaff(Staff staff){
        binder.setBean(staff);
    }
    public Button getSaveButton() {
        return save;
    }

    public Staff getCurrentStaff() {
        return binder.getBean();
    }

}
