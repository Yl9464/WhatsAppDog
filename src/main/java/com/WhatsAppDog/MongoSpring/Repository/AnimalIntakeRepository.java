package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalIntakeRepository extends MongoRepository<AnimalIntake, String> {
}
