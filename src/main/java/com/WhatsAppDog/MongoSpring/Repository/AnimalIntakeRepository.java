package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalIntakeRepository extends MongoRepository<AnimalIntake, String> {
    //List<Animal> findByNameContainingIgnoreCase(String name);
}

