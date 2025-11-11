package com.WhatsAppDog.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="Staff")

public class Staff {
    @Id //sets value as primary key
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String title; //employee or volunteer
    private Integer age;
    //contact info

}
