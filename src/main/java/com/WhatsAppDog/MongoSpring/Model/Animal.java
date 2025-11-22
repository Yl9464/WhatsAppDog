package com.WhatsAppDog.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="Dogs")

public class Animal {
    @Id //sets value as primary key
    @EqualsAndHashCode.Include
    private ObjectId id;
    private Integer idNu;
    private String name;
    private String breed;
    private Integer age;
    private Boolean aggression;
    private ObjectId imageId;

}

