package com.bora.fitness.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="trainer")
public class Trainer extends User{

    @OneToOne
    @JoinColumn(name="fitness_center_id")
    private FitnessCenter fitnessCenter;


    public Trainer() {
    }

    public Trainer(Long id, String username, String password, String firstName, String lastName, String phoneNumber, String email, String role, Boolean status) {
        super(id, username, password, firstName, lastName, phoneNumber, email, role, status);
    }

    public Trainer(Long id, String username, String password, String firstName, String lastName, String phoneNumber, String email, Date birthDate, String role, Boolean status) {
        super(id, username, password, firstName, lastName, phoneNumber, email, birthDate, role, status);
    }

    public Trainer(String username, String password, String firstName, String lastName, String phoneNumber, String email, String role, Boolean status) {
        super(username, password, firstName, lastName, phoneNumber, email, role, status);
    }
}
