package com.bora.fitness.repository;

import com.bora.fitness.model.Hall;
import com.bora.fitness.service.HallService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {


}
