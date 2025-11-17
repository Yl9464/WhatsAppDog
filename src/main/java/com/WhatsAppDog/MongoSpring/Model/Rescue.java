package com.WhatsAppDog.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//indicates table name in database

//reduces need for getters, setters etc
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (collection ="Rescues")

public class Rescue {
    @Id //sets value as primary key
    private ObjectId id;
    private Integer license_id;
    private String name;
    private String state;
    private String type;
    private String email;
}
