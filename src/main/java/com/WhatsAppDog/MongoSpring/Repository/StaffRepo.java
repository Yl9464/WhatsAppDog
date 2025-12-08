package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StaffRepo extends  MongoRepository<Staff,String> {

  List<Staff> findByIsEmployee();

    @Query("{ '$or': [ {'firstName': { $regex: ?0, $options: 'i' }}, {'lastName': { $regex: ?0, $options: 'i' }} ] }")
    List<Staff> searchPerson(String value);
}
