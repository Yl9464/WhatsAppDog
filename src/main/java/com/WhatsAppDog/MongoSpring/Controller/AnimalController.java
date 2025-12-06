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

   public List<Animal> findAll() {return animalRepo.findAll();}

    public Animal add(Animal animal){ return animalRepo.save(animal);}

    public Animal update(Animal animal){ return animalRepo.save(animal);}

    public void delete(Animal animal){ animalRepo.delete(animal);}

    public Animal saveAnimal(Animal animal){
       return animalRepo.save(animal);}
}
