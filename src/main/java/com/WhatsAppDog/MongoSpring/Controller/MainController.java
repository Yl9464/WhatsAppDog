//creates routes
package com.WhatsAppDog.MongoSpring.Controller;
import com.WhatsAppDog.MongoSpring.Model.Rescue;
import com.WhatsAppDog.MongoSpring.Repository.RescueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Define api paths
@RestController
public class MainController {
    @Autowired //connects repo and controller
    private RescueRepo rescueRepo;

    @PostMapping("/addRescue")
        public String saveRescue(@RequestBody Rescue rescue){
        rescueRepo.save(rescue);

            return "Added Successfully";
    }

    @GetMapping("/getAllRescues")
    public List<Rescue> getRescues(){
        return rescueRepo.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        rescueRepo.deleteById(id);

        return "Deleted Successfully";
    }

}
