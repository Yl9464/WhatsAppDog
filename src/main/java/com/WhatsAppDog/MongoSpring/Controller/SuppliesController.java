//creates routes
package com.WhatsAppDog.MongoSpring.Controller;

import com.WhatsAppDog.MongoSpring.Model.Supplies;
import com.WhatsAppDog.MongoSpring.Repository.SuppliesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

//Define api paths, call repos
@Service
public class SuppliesController implements CrudListener<Supplies> {

    @Autowired //connects repo and controller
    private final SuppliesRepo suppliesRepo;

    public SuppliesController(SuppliesRepo suppliesRepo) {
        this.suppliesRepo = suppliesRepo;
    }

  //  @Override //indicates the method is meant to override a method from a parent class or an interface
   public List<Supplies> findAll(){
        return suppliesRepo.findAll();
    }
    //query by item name
    public List<Supplies> searchItem(String query){
        if(query == null || query.isBlank()){
            return findAll();
        }
        return suppliesRepo.searchItem(query);
    }


    public Supplies add(Supplies supply){
        return suppliesRepo.save(supply);
    }
    //@Override
    public Supplies update(Supplies supply){
        return suppliesRepo.save(supply);
    }
    //@Override
    public void delete(Supplies supply){
        suppliesRepo.delete(supply);
    }




}