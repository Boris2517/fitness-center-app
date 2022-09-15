package com.bora.fitness.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Training training;

    @ManyToOne
    private Trainer trainer;

    @ManyToMany
    private List<Member> memberList;

    @Column(name="member_num")
    private int memberNum;

    @Column(name="date")
    private Date date;

    @Column(name="time")
    private Time time;

    @ManyToMany
    private List<Rating> ratings;

}
