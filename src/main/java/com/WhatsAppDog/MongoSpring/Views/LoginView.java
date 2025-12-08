package com.WhatsAppDog.MongoSpring.Views;

import com.WhatsAppDog.MongoSpring.Controller.UserController;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
        setPadding(true);
        setSpacing(true);

        H1 title = new H1("WhatsApp Dog");
        title.getStyle().set("color", "#2c3e50");
        title.getStyle().set("margin-bottom", "20px");

        //Login
        LoginForm loginForm = new LoginForm();
        loginForm.setForgotPasswordButtonVisible(false);
        loginForm.addLoginListener(event -> {
            String username = event.getUsername();
            String password = event.getPassword();

            if (userController.authenticate(username, password)) {
                loginForm.setError(false);
                // Redirect to main view after successful login
                getUI().ifPresent(ui -> ui.navigate("homeView"));
            } else {
                loginForm.setError(true);
                Notification.show("Invalid username or password", 3000, Notification.Position.TOP_CENTER);
            }
        });

        add(title, loginForm);
        getStyle().set("background-color", "#ecf0f1");
        getStyle().set("padding", "50px");
        getStyle().set("border-radius", "10px");
        getStyle().set("box-shadow", "0 4px 6px rgba(0,0,0,0.1)");
    }

}
