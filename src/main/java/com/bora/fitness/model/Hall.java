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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="fitness_center_id")
//    @NotNull
//    private FitnessCenter fitnessCenter;

    //Terminska lista treninga (koji trening se održava u kom danu i po kojoj ceni
    //- isti trening se može u istim danima održavati u različitim salama, veza
    //N:N), koja sadrži i broj prijavljenih članova za taj termin.

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    public Hall() {
    }

    public Hall(String mark, int capacity) {
        this.mark = mark;
        this.capacity = capacity;
    }

    public Hall(Long id, String mark, int capacity) {
        this.id = id;
        this.mark = mark;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
