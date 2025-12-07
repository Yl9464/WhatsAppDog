package com.WhatsAppDog.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="Animals")

public class Animal {
    @Id //sets value as primary key
    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String type;
    private Integer age;
    private boolean isFemale;
    private boolean isAggressive;
    private String imageUrl; //stores img path


}
