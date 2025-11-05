//Links Rescue class with mongodb compass allowing to insert values
package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Rescue;
import org.springframework.data.mongodb.repository.MongoRepository;

//Links with rescue class
public interface RescueRepo extends MongoRepository<Rescue, Integer> {



}
