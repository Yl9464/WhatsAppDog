//creates routes
package com.WhatsAppDog.MongoSpring.Controller;
import com.WhatsAppDog.MongoSpring.Model.Dog;
import com.WhatsAppDog.MongoSpring.Model.Rescue;
import com.WhatsAppDog.MongoSpring.Repository.DogRepo;
import com.WhatsAppDog.MongoSpring.Repository.RescueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Define api paths
@Service
@RestController
public class MainController {
    @Autowired //connects repo and controller
    private RescueRepo rescueRepo;
    @Autowired //connects repo and controller
    private DogRepo dogRepo;

    //Collection: Rescues
    @PostMapping("/addRescue")
    public String saveRescue(@RequestBody Rescue rescue) {
        rescueRepo.save(rescue);
        return "Rescue Added Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        rescueRepo.deleteById(id);

        return "Deleted Successfully";
    }

    //Collection: Dogs
    @PostMapping("/addDog")
    public String saveDog(@RequestBody Dog dog) {
        dogRepo.save(dog);
        return "Dog Added Successfully";
    }

    @GetMapping("/getAllDogs")
    public List<Dog> getDogs() {
        return dogRepo.findAll();
    }

    @GetMapping("/dogs/{breed}")
    public List<Dog> getDogsByBreed(@PathVariable("breed") String breed) {
      return dogRepo.findByBreed(breed);

    }


}
