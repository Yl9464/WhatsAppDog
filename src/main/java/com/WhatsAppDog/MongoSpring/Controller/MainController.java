//creates routes
package com.WhatsAppDog.MongoSpring.Controller;
import com.WhatsAppDog.MongoSpring.Model.Dog;
import com.WhatsAppDog.MongoSpring.Model.Rescue;
import com.WhatsAppDog.MongoSpring.Model.Supplies;

import com.WhatsAppDog.MongoSpring.Repository.DogRepo;
import com.WhatsAppDog.MongoSpring.Repository.RescueRepo;
import com.WhatsAppDog.MongoSpring.Repository.SuppliesRepo;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

//Define api paths, call repos
@Service
public class MainController implements CrudListener<Supplies> {
    @Autowired //connects repo and controller
    private RescueRepo rescueRepo;
    @Autowired //connects repo and controller
    private DogRepo dogRepo;
    @Autowired //connects repo and controller
    private final SuppliesRepo suppliesRepo;


    //constructor for repository and usable in methods
    public MainController(SuppliesRepo suppliesRepo) {
        this.suppliesRepo = suppliesRepo;
    }

    @Override
    //findAll() will run out of memory if db grows substantially
    public List<Supplies> findAll(){
        return suppliesRepo.findAll();
    }
    @Override
    public Supplies add(Supplies supply){
        return suppliesRepo.save(supply);
    }
    @Override
    public Supplies update(Supplies supply){
        return suppliesRepo.save(supply);
    }
    @Override
    public void delete(Supplies supply){
        suppliesRepo.delete(supply);
    }

}
