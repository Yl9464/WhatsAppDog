package com.WhatsAppDog.MongoSpring.Vaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route("view")
@UIScope
public class ViewComponent extends NativeLabel {

    public ViewComponent(@Autowired Greeter greeter) {
        // it's the same Greeter instance as in the RootComponent class
        setText(greeter.sayHello());
    }
}