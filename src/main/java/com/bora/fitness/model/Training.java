package com.bora.fitness.model;


import javax.persistence.*;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="duration")
    private int duration; //minutes

    @ManyToOne
    private TrainingType trainingType;



}
