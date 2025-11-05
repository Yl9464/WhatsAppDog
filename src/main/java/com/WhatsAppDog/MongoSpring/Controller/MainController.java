//creates routes
package com.WhatsAppDog.MongoSpring.Controller;
import com.WhatsAppDog.MongoSpring.Model.Rescue;
import com.WhatsAppDog.MongoSpring.Repository.RescueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//Define api paths
@RestController
public class MainController {
    @Autowired
            //connects repo and controller
    RescueRepo rescueRepo;

    @PostMapping("/addRescue")
    public void addRescue(@RequestBody Rescue rescue) {
        rescueRepo.save(rescue);

    }
}
