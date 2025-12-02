package com.WhatsAppDog.MongoSpring.Controller;

import com.WhatsAppDog.MongoSpring.Model.Staff;
import com.WhatsAppDog.MongoSpring.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Service
public class StaffController implements CrudListener<Staff> {
    @Autowired
    private final StaffRepo staffRepo;

    @Autowired
    public StaffController(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    //@Override
    public List<Staff> findAll() {
        return staffRepo.findAll();
    }

    public List<Staff> findByJobTitle(String title){
        return staffRepo.findByJobTitle(title);
    }


    public Staff add(Staff staff){
        if(staff == null){
            return null;
        }
        return staffRepo.save(staff);}
   // @Override
    public Staff update(Staff staff){ return staffRepo.save(staff);}
    //@Override
    //Dog Data
    public  void delete(Staff staff){ staffRepo.delete(staff);}

}
