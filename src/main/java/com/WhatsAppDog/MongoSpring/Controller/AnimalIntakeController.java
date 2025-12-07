package com.WhatsAppDog.MongoSpring.Controller;

import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import com.WhatsAppDog.MongoSpring.Repository.AnimalIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AnimalIntakeController {

    @Autowired
    private AnimalIntakeRepository repo;

    public List<AnimalIntake> findAll() {
        return repo.findAll();
    }

    public AnimalIntake save(AnimalIntake intake) {
        return repo.save(intake);
    }

    public void delete(AnimalIntake intake) {
        repo.delete(intake);
    }
}
