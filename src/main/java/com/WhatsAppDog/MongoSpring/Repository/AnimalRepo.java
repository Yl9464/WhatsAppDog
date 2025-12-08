package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends MongoRepository<Animal,String> {
//    List<Animal> findByNameContainingIgnoreCase(String name);
}
