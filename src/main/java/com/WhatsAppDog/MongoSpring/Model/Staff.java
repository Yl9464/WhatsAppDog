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
@Document(collection ="Staff")

public class Staff {
    @Id //sets value as primary key
    @EqualsAndHashCode.Include
    private ObjectId id;
    private Integer  employee_id;
    private String   firstName;
    private String   lastName;
    private String   email;
    private String   jobTitle;
    private String   salary;

}
