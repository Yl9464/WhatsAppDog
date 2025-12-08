package com.WhatsAppDog.MongoSpring.Controller;

import com.WhatsAppDog.MongoSpring.Model.AnimalIntake;
import com.WhatsAppDog.MongoSpring.Repository.AnimalIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AnimalIntakeController {

    private final AnimalIntakeRepository intakeRepo;

    @Autowired
    public AnimalIntakeController(AnimalIntakeRepository intakeRepo) {
        this.intakeRepo = intakeRepo;
    }

    public AnimalIntake saveAnimal(AnimalIntake animal) {
        return intakeRepo.save(animal);
    }

    public List<AnimalIntake> findAll() {
        return intakeRepo.findAll();
    }

    public AnimalIntake updateAnimal(AnimalIntake animal) {
            return intakeRepo.save(animal);

    }
    public void delete(AnimalIntake intake) {
        intakeRepo.delete(intake);
    }
}
