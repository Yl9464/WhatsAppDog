package com.WhatsAppDog.MongoSpring.Repository;
import com.WhatsAppDog.MongoSpring.Model.Dog;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface SuppliesRepo extends MongoRepository<Supplies, String> {

}
