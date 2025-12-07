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
   public List<Animal> findAll() {return animalRepo.findAll();}

    public List<Animal> findByType(String type){return animalRepo.findByType("Dog");}
    @Override
    public Animal add(Animal animal){ return animalRepo.save(animal);}

    @Override
    public Animal update(Animal animal){ return animalRepo.save(animal);}

    @Override
    public void delete(Animal animal){ animalRepo.delete(animal);}


}
