package com.WhatsAppDog.MongoSpring.Vaadin;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.template.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.spring.annotation.SpringComponent;
@Tag("example") //access frontend/src/example.ts
@JsModule("./src/example-template.ts")
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class ExampleTemplate {
    @Id("content")
    private Span content;

    public ExampleTemplate(@Autowired Greeter bean) {
        // Set the initial value of the span
        content.setText(bean.sayHello());
    }
}
