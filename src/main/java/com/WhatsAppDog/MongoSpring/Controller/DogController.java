package com.WhatsAppDog.MongoSpring.Controller;

import com.WhatsAppDog.MongoSpring.Model.Dog;
import com.WhatsAppDog.MongoSpring.Repository.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Service
public class DogController implements CrudListener<Dog>{
   @Autowired
    private final DogRepo dogRepo;

   public DogController(DogRepo dogRepo) {
       this.dogRepo = dogRepo;
   }
   @Override
   //Dog Data
   public List<Dog> findAll() {return dogRepo.findAll();}
    @Override
    //Dog Data
    public Dog add(Dog dog){ return dogRepo.save(dog);}
    @Override
    //Dog Data
    public Dog update(Dog dog){ return dogRepo.save(dog);}
    @Override
    //Dog Data
    public  void delete(Dog dog){ dogRepo.delete(dog);}

}
