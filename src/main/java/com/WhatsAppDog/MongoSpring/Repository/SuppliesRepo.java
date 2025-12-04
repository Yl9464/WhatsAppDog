package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Supplies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface SuppliesRepo extends MongoRepository<Supplies, String> {
    @Query("""
    { $or: [
        { "item":        { $regex: ?0, $options: 'i' }},
        { "category":       { $regex: ?0, $options: 'i' }},
      ]
    }
""")
    List<Supplies> searchItem(String query);

}