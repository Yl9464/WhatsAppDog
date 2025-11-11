package com.WhatsAppDog.MongoSpring.Repository;

import com.WhatsAppDog.MongoSpring.Model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepo extends  MongoRepository<Staff,String> {
}
