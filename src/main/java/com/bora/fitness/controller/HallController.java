package com.bora.fitness.controller;

import com.bora.fitness.model.Hall;
import com.bora.fitness.model.dto.HallDTO;
import com.bora.fitness.service.HallService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/fitnessCenters")
public class HallController {

    private ModelMapper mp = new ModelMapper();
    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }


    @PostMapping("/{centerId}/halls")
    public ResponseEntity<HallDTO> createHall(@RequestBody Hall hall, @PathVariable Long centerId){

        Hall newHall = hallService.createHall(hall,centerId);
        HallDTO hallDTO = mp.map(newHall, HallDTO.class);
        hallDTO.setFitnessCenterID(centerId);
        return new ResponseEntity<>(hallDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{centerId}/halls/{hallId}")
    public ResponseEntity<HallDTO> getHallById(@PathVariable Long centerId, @PathVariable Long hallId){

        Hall hall = hallService.getHallById(centerId, hallId);
        HallDTO hallDTO = mp.map(hall, HallDTO.class);
        hallDTO.setFitnessCenterID(centerId);
        return new ResponseEntity<>(hallDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{centerId}/halls")
    public ResponseEntity<List<HallDTO>> getHallForFitnessCenter(@PathVariable Long centerId){

        List<Hall> hallList = hallService.getHallsByFitnessCenter(centerId);
        List<HallDTO> hallDTOList = hallList.stream()
                .map(hall -> mp.map(hall, HallDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(hallDTOList,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{centerId}/halls")
    public ResponseEntity<HallDTO> updateHall(@PathVariable Long centerId,@RequestBody Hall hall){

        Hall updatedHall = hallService.updateHall(centerId,hall);
        HallDTO hallDTO = mp.map(updatedHall, HallDTO.class);
        hallDTO.setFitnessCenterID(centerId);
        return new ResponseEntity<>(hallDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{centerId}/halls/{hallId}")
    public ResponseEntity<Void> deleteHall(@PathVariable Long centerId, @PathVariable Long hallId){
        hallService.deleteHall(centerId,hallId);

        return ResponseEntity.noContent().build();
    }

}
