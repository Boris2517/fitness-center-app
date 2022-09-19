package com.bora.fitness.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.bora.fitness.model.FitnessCenter;
import com.bora.fitness.model.Hall;
import com.bora.fitness.repository.FitnessCenterRepository;
import com.bora.fitness.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallService {

    private final HallRepository hallRepository;
    private final FitnessCenterRepository fitnessCenterRepository;

    public HallService(HallRepository hallRepository, FitnessCenterRepository fitnessCenterRepository) {
        this.hallRepository = hallRepository;
        this.fitnessCenterRepository = fitnessCenterRepository;
    }

    public Hall createHall(Hall hall, Long centerId) {
        //check if center exist
        try {
            FitnessCenter fc = fitnessCenterRepository.findById(centerId).get();
            fc.addHall(hall);
            fitnessCenterRepository.save(fc);

        }catch (Exception e){
            throw new RuntimeException("Hall can not be added!");
        }

        return hall;
    }

    public Hall getHallById(Long centerId, Long hallId) {
        Hall hall;
        try{
            hall = fitnessCenterRepository.findById(centerId).get()
                    .getHallList().stream()
                    .map(hall1 -> hall1.getId() == hallId ? hall1 : null).collect(Collectors.toList())
                    .get(0);
        }catch (Exception e){
            throw new RuntimeException("Hall does not exist!");
        }
        return hall;
    }

    public Hall updateHall(Long centerId, Hall hall) {
        Hall updatedHall = new Hall();
        try{
            Hall oldHall = fitnessCenterRepository.findById(centerId).get()
                    .getHallList().stream()
                    .map(hall1 -> hall1.getId() == hall.getId() ? hall1 : null).collect(Collectors.toList())
                    .get(0);

            updatedHall.setId(oldHall.getId());
            updatedHall.setMark(hall.getMark());
            updatedHall.setCapacity(hall.getCapacity());
        }catch (Exception e){
            throw new RuntimeException("Hall does not exist!");
        }
        return updatedHall;
    }


    public void deleteHall(Long centerId, Long hallId) {
        try{
            FitnessCenter fitnessCenter = fitnessCenterRepository.findById(centerId).get();
            fitnessCenter.removeHall(hallId);
            fitnessCenterRepository.save(fitnessCenter);

        }catch (Exception e){
            throw new RuntimeException("Hall does not exist!");
        }

    }

    public List<Hall> getHallsByFitnessCenter(Long centerId) {
        List<Hall> hallList;
        try{
            hallList = fitnessCenterRepository.findById(centerId).get().getHallList();
        }catch (Exception e){
            throw new RuntimeException("Fitness center does not exits!");
        }
        return hallList;
    }
}
