package com.WhatsAppDog.MongoSpring.Repository;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface SuppliesRepo extends MongoRepository<Supplies, String> {

    List<Supplies> findByItemIgnoreCase(String item);
}