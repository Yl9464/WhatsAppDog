package com.WhatsAppDog.MongoSpring.Controller;

import com.WhatsAppDog.MongoSpring.Model.Animal;
import com.WhatsAppDog.MongoSpring.Repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Service
public class AnimalController implements CrudListener<Animal>{
   @Autowired
    private final AnimalRepo animalRepo;

   public AnimalController(AnimalRepo animalRepo) {
       this.animalRepo = animalRepo;
   }
   @Override
   //Dog Data
   public List<Animal> findAll() {return animalRepo.findAll();}
    @Override
    //Dog Data
    public Animal add(Animal dog){ return animalRepo.save(dog);}
    @Override
    //Dog Data
    public Animal update(Animal dog){ return animalRepo.save(dog);}
    @Override
    //Dog Data
    public  void delete(Animal dog){ animalRepo.delete(dog);}

}
