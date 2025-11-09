package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogRepo extends MongoRepository<Dog,Integer> {
}
