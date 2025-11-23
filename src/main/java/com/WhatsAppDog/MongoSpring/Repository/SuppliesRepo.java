package com.WhatsAppDog.MongoSpring.Repository;
import com.WhatsAppDog.MongoSpring.Model.Supplies;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SuppliesRepo extends MongoRepository<Supplies, String> {

}
