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
//implements this.""
@AllArgsConstructor
@Document(collection ="Supplies")
public class Supplies {
    @Id //sets value as primary key
    @EqualsAndHashCode.Include //creates getters and setters for each field ( equals() & hashcode)
    private ObjectId id;
    private String   item;
    private String   category;
    private Integer  quantity;
    private String   supplier;
}
