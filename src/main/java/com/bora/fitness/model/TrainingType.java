package com.bora.fitness.model;

import javax.persistence.*;

@Entity
public class TrainingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @OneToOne
    private Trainer trainer; //creator of training type

}
