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

    public StaffController(StaffRepo repo){
        this.staffRepo = repo;

    }
    //@Autowired
    public List<Staff> findAll() {
        return staffRepo.findAll();
    }

    public List<Staff> getEmployeeStatus(Boolean employee) {
        return staffRepo.findByIsEmployee(employee);
    }

    public Staff add(Staff staff){
        if(staff == null){
            return null;
        }
        return staffRepo.save(staff);}
   public Staff save(Staff staff){
        return staffRepo.save(staff);
   }
    // @Override
    public Staff update(Staff staff){ return staffRepo.save(staff);}
    //@Override
    //Dog Data
    public  void delete(Staff staff){ staffRepo.delete(staff);}

}
