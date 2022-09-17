package com.bora.fitness.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="member")
public class Member extends User{

    @ManyToMany
    private List<FitnessCenter> fitnessCenterList;

    public Member() {
        super();
    }

    public Member(Long id, String username, String password, String firstName, String lastName, String phoneNumber, String email, Date birthDate, String role, Boolean status, List<FitnessCenter> fitnessCenterList) {
        super(id, username, password, firstName, lastName, phoneNumber, email, birthDate, role, status);
        this.fitnessCenterList = fitnessCenterList;
    }

    public Member(String username, String password, String firstName, String lastName, String phoneNumber, String email, String role, Boolean status) {
        super(username, password, firstName, lastName, phoneNumber, email, role, status);
    }
}
