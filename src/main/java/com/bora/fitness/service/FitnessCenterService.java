package com.bora.fitness.service;

import com.bora.fitness.model.FitnessCenter;
import com.bora.fitness.repository.FitnessCenterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FitnessCenterService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final FitnessCenterRepository fitnessCenterRepository;

    public FitnessCenterService(FitnessCenterRepository fitnessCenterRepository) {
        this.fitnessCenterRepository = fitnessCenterRepository;
    }

    public FitnessCenter createFitnessCenter(FitnessCenter fitnessCenter) {

        //Name is already in use
        FitnessCenter fitnessCenterByName = fitnessCenterRepository.findFitnessCenterByName(fitnessCenter.getName());
        if(fitnessCenterByName != null){
            throw new RuntimeException("Fitness Center name already in use.");
        }

        //Email is already in use
        FitnessCenter fitnessCenterByEmail = fitnessCenterRepository.findFitnessCenterByEmail(fitnessCenter.getEmail());
        if(fitnessCenterByEmail != null){
            throw new RuntimeException("Fitness Center email i already in use.");
        }

        return fitnessCenterRepository.save(fitnessCenter);
    }

    public FitnessCenter getFitnessCenterById(Long id) {

        return fitnessCenterRepository.findById(id).orElse(null);
    }

    public FitnessCenter updateFitnessCenter(FitnessCenter fitnessCenter) {
        Optional<FitnessCenter> oldFitnessCenter = fitnessCenterRepository.findById(fitnessCenter.getId());
        FitnessCenter updatedFitnessCenter = new FitnessCenter(
                oldFitnessCenter.get().getId(),
                fitnessCenter.getName(),
                fitnessCenter.getAddress(),
                fitnessCenter.getPhoneNumber(),
                fitnessCenter.getEmail()
        );
        return fitnessCenterRepository.save(updatedFitnessCenter);
    }

    public void deleteFitnessCenter(Long id) {
        try{
            fitnessCenterRepository.deleteById(id);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    public List<FitnessCenter> getAllFitnessCenters(int page, int limit) {
        Pageable pageable = PageRequest.of(--page,limit);
        List<FitnessCenter> fitnessCenters = fitnessCenterRepository.findAll(pageable).getContent();
        return fitnessCenters;
    }
}
