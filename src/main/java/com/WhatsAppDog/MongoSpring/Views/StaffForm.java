package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class StaffForm extends Dialog {
    private final Binder<Staff> binder = new Binder<>(Staff.class);
    TextField firstName = new TextField("First Name");
    TextField lastName = new TextField("Last Name");
    TextField email = new TextField("Email");
    ComboBox isEmployee = new ComboBox("Select Position");

    public StaffForm(Staff staff, Runnable onSave) {
        FormLayout formLayout = new FormLayout();

        // Add more fields as needed
        isEmployee.setLabel("Employee");
        isEmployee.setLabel("Volunteer");
        binder.bindInstanceFields(this);
        binder.setBean(staff);

        formLayout.add(firstName, lastName, email, isEmployee);

        Button saveButton = new Button("Save", e -> {
            if (binder.validate().isOk()) {
                onSave.run(); // Call callback to save via controller
                this.close();
            }
        });

        Button cancelButton = new Button("Cancel", e -> this.close());

        add(formLayout, saveButton, cancelButton);
        setWidth("400px");
    }


}
