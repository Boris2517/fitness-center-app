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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainer> trainerList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Hall> hallList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="fitness_center_members",
            joinColumns = @JoinColumn(name="fitness_center_id"),
            inverseJoinColumns = @JoinColumn(name="member_id")
    )
    private List<Member> memberList;

    public FitnessCenter() {
    }

    public FitnessCenter(Long id, String name, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public FitnessCenter(Long id, String name, String address, String phoneNumber, String email, List<Trainer> trainerList, List<Hall> hallList, List<Member> memberList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.trainerList = trainerList;
        this.hallList = hallList;
        this.memberList = memberList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }

    public List<Hall> getHallList() {
        return hallList;
    }

    public void setHallList(List<Hall> hallList) {
        this.hallList = hallList;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
