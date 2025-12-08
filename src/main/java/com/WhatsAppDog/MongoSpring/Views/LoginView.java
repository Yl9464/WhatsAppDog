package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class LoginView extends VerticalLayout {

    @Autowired

    private UserController userController;

    public LoginView(UserController userController) {
       this.userController = userController;

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 title = new H1("Login");

        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener(e -> {
            userController.login(username.getValue(), password.getValue()).ifPresentOrElse(user -> {
                if (user.getPassword().equals(password.getValue())) { // Plaintext for demo
                    UI.getCurrent().navigate("homeView");
                } else {
                    Notification.show("Incorrect password", 3000, Notification.Position.MIDDLE);
                }
            }, () -> Notification.show("User not found", 3000, Notification.Position.MIDDLE));
        });

        add(title, username, password, loginButton);
    }
}
