package com.bora.fitness.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="member")
public class Member extends User{

    @ManyToMany
    private List<FitnessCenter> fitnessCenterList;
}
