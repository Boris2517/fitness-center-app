package com.bora.fitness.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="mark")
    private String mark;

    @Column(name="capacity")
    private int capacity;

    @ManyToOne()
    @JoinColumn(name="fitness_center_id")
    @NotNull
    private FitnessCenter fitnessCenter;

    //Terminska lista treninga (koji trening se održava u kom danu i po kojoj ceni
    //- isti trening se može u istim danima održavati u različitim salama, veza
    //N:N), koja sadrži i broj prijavljenih članova za taj termin.

    @ManyToMany
    private List<Appointment> appointmentList;
}
