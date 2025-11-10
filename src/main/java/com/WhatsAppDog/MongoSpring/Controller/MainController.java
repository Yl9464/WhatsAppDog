//creates routes
package com.WhatsAppDog.MongoSpring.Controller;
import com.WhatsAppDog.MongoSpring.Model.Dog;
import com.WhatsAppDog.MongoSpring.Model.Rescue;
import com.WhatsAppDog.MongoSpring.Model.Supplies;

import com.WhatsAppDog.MongoSpring.Repository.DogRepo;
import com.WhatsAppDog.MongoSpring.Repository.RescueRepo;
import com.WhatsAppDog.MongoSpring.Repository.SuppliesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Define api paths
@Service
@RestController
public class MainController {
    @Autowired //connects repo and controller
    private RescueRepo rescueRepo;
    @Autowired //connects repo and controller
    private DogRepo dogRepo;
    @Autowired //connects repo and controller
    private SuppliesRepo suppliesRepo;


    //Collection: Rescues
    @PostMapping("/addRescue")
    public String saveRescue(@RequestBody Rescue rescue) {
        rescueRepo.save(rescue);
        return "Rescue Added Successfully";
    }
    @GetMapping("/getAllRescues")
    public List<Rescue> getAllRescues() {
        return rescueRepo.findAll();
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

    //Collection: Supplies
    @PostMapping("/addSupplies")
    public String saveDog(@RequestBody Supplies supplies) {
        suppliesRepo.save(supplies);
        return "Dog Added Successfully";
    }

    @GetMapping("/getAllSupplies")
    public List<Supplies> getAllSupplies() {
        return suppliesRepo.findAll();
    }
    @GetMapping("/supplies/{category}")
    public List<Supplies> getSuppliesByCategory(@PathVariable("category") String category) {
        return suppliesRepo.findByCategory(category);

    }
//    @GetMapping("/supplies/{supplier}")
//    public List<Supplies> getBySupplier(@PathVariable("supplier") String supplier) {
//        return suppliesRepo.findBySupplier(supplier);
//
//    }
}
