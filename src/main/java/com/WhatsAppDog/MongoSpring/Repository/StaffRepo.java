package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StaffRepo extends  MongoRepository<Staff,String> {
  List<Staff> findByJobTitle(String jobTitle);
}
