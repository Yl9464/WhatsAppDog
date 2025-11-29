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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection ="Staff")

public class Staff  {
    @Id //sets value as primary key
    @EqualsAndHashCode.Include
    private ObjectId id;
   public Integer  employee_id;
   public String   firstName;
   public String   lastName;
   public String   email;
   public String   jobTitle;
   public String   salary;

}
