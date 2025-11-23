package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;

//Links with animal class
public interface AnimalRepo extends MongoRepository<Animal,Integer> {

}
