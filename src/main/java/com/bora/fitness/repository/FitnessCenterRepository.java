package com.bora.fitness.repository;

import com.bora.fitness.model.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessCenterRepository extends JpaRepository<FitnessCenter, Long> {
    FitnessCenter findFitnessCenterByName(String name);
    FitnessCenter findFitnessCenterByEmail(String email);
}
