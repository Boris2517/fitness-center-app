package com.bora.fitness.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class FitnessCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @OneToMany
    private List<Trainer> trainerList;

    @OneToMany
    private List<Hall> hallList;

    @ManyToMany
    @JoinTable(
            name="fitness_center_members",
            joinColumns = @JoinColumn(name="fitness_center_id"),
            inverseJoinColumns = @JoinColumn(name="member_id")
    )
    private List<Member> memberList;


}
