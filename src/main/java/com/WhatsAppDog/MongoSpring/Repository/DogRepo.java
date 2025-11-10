package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.*;

//Links with dog class
public interface DogRepo extends MongoRepository<Dog,Integer> {
    //find dog by breed
    List<Dog> findByBreed(String breed);

}
