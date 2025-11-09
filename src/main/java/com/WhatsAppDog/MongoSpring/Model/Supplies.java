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
@Document(collection ="Supplies")
public class Supplies {
    @Id //sets value as primary key
    private ObjectId id;
    private String item;
    private String category;
    private Integer quantity;
    private String supplier;
}
