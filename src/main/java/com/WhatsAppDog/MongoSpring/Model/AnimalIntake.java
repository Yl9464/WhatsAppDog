package com.WhatsAppDog.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Animals")  //Existing db
public class AnimalIntake {

    @Id
    //@EqualsAndHashCode.Include
    private String id;

    private String animalId;
    private String animalName;
    private String species;
    private String breed;
    private String color;
    private String intakeType;
    private boolean medicalRecords;
    private String staffInitials;

    private Double temperature;
    private boolean unableToWalk;
    private boolean troubleBreathing;
    private boolean bleeding;
    private boolean brokenBones;

}