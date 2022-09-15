package com.bora.fitness.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer extends User{

    @OneToOne
    @JoinColumn(name="fitness_center_id")
    private FitnessCenter fitnessCenter;

}
