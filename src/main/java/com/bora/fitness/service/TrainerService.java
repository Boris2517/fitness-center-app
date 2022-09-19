package com.bora.fitness.service;

import com.bora.fitness.model.Trainer;
import com.bora.fitness.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer getTrainerById(Long id) {
        Trainer result;
        try{
            result = trainerRepository.findById(id).get();
        }catch(Exception exception){
            throw new RuntimeException("User does not exist!");
        }
        return result;
    }

    public Trainer updateTrainer(Trainer trainer) {
        Trainer updatedTrainer;
        try{
            Trainer exist = trainerRepository.findById(trainer.getId()).get();
            updatedTrainer = new Trainer(
                    exist.getId(),
                    trainer.getUsername(),
                    trainer.getPassword(),
                    trainer.getFirstName(),
                    trainer.getLastName(),
                    trainer.getPhoneNumber(),
                    trainer.getEmail(),
                    trainer.getRole(),
                    trainer.getStatus()
            );

        }catch (Exception e){
            throw new RuntimeException("Trainer does not exist!");
        }

        return trainerRepository.save(updatedTrainer);
    }

    public void deleteTrainer(Long id) {
        try{
            trainerRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Trainer does not exist!");
        }
    }
}
