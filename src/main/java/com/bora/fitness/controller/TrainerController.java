package com.bora.fitness.controller;

import com.bora.fitness.model.Trainer;
import com.bora.fitness.model.dto.UserDTO;
import com.bora.fitness.service.TrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/trainers")
public class TrainerController {

    private ModelMapper mp = new ModelMapper();
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    //DELETE
    @PostMapping
    public ResponseEntity<UserDTO> createTrainer(@RequestBody Trainer trainer){
        Trainer newTrainer = trainerService.createTrainer(trainer);
        UserDTO userDTO = mp.map(newTrainer,UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getTrainers(
            @RequestParam(value="page",defaultValue = "1") int page,
            @RequestParam(value="limit",defaultValue = "3") int limit
    ){
        List<Trainer> trainers = trainerService.getAllTrainers(page,limit);

        List<UserDTO> userDTOS = trainers.stream()
                .map(trainer -> mp.map(trainer, UserDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(userDTOS,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getTrainerById(@PathVariable Long id){
        Trainer trainer = trainerService.getTrainerById(id);
        UserDTO userDTO = mp.map(trainer,UserDTO.class);
        return new ResponseEntity<>(userDTO,HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateTrainer(@RequestBody Trainer trainer){
        Trainer updateTrainer = trainerService.updateTrainer(trainer);
        UserDTO userDTO = mp.map(updateTrainer,UserDTO.class);
        return new ResponseEntity<>(userDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id){
        trainerService.deleteTrainer(id);

        return ResponseEntity.noContent().build();
    }
}
