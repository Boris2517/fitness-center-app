package com.bora.fitness.controller;

import com.bora.fitness.model.FitnessCenter;
import com.bora.fitness.model.dto.FitnessCenterDTO;
import com.bora.fitness.service.FitnessCenterService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/fitnessCenters")
public class FitnessCenterController {

    private ModelMapper mp = new ModelMapper();
    private final FitnessCenterService fitnessCenterService;


    public FitnessCenterController(FitnessCenterService fitnessCenterService) {
        this.fitnessCenterService = fitnessCenterService;
    }

    @PostMapping
    private ResponseEntity<FitnessCenterDTO> createFitnessCenter(@RequestBody FitnessCenter fitnessCenter){
        FitnessCenter newFitnessCenter = fitnessCenterService.createFitnessCenter(fitnessCenter);

        FitnessCenterDTO fitnessCenterDTO = mp.map(newFitnessCenter,FitnessCenterDTO.class);

        return new ResponseEntity<>(fitnessCenterDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FitnessCenterDTO> getFitnessCenterById(@PathVariable Long id){
        //exception handler needed
        FitnessCenter fitnessCenter = fitnessCenterService.getFitnessCenterById(id);
        FitnessCenterDTO fitnessCenterDTO = mp.map(fitnessCenter,FitnessCenterDTO.class);
        return new ResponseEntity<>(fitnessCenterDTO, HttpStatus.ACCEPTED);
    }

    @PutMapping()
    private ResponseEntity<FitnessCenterDTO> updateFitnessCenter(@RequestBody FitnessCenter fitnessCenter){
        FitnessCenter updatedFitnessCenter = fitnessCenterService.updateFitnessCenter(fitnessCenter);
        FitnessCenterDTO fitnessCenterDTO = mp.map(updatedFitnessCenter, FitnessCenterDTO.class);

        return new ResponseEntity<>(fitnessCenterDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteFitnessCenter(@PathVariable Long id){

        fitnessCenterService.deleteFitnessCenter(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    private ResponseEntity<List<FitnessCenterDTO>> getAllFitnessCenters(
            @RequestParam(value="page",defaultValue = "1") int page,
            @RequestParam(value="limit",defaultValue = "3") int limit
        ){

        List<FitnessCenter> fitnessCenters =  fitnessCenterService.getAllFitnessCenters(page,limit);
        List<FitnessCenterDTO> fitnessCenterDTOS = fitnessCenters.stream()
                .map(fitnessCenter -> mp.map(fitnessCenter, FitnessCenterDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(fitnessCenterDTOS,HttpStatus.ACCEPTED);
    }
}
