package com.bora.fitness.model.dto;

public class HallDTO {
    private Long id;
    private String mark;
    private int capacity;

    private Long fitnessCenterID;

    public HallDTO() {
    }

    public HallDTO(Long id, String mark, int capacity, Long fitnessCenterID) {
        this.id = id;
        this.mark = mark;
        this.capacity = capacity;
        this.fitnessCenterID = fitnessCenterID;
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

    public Long getFitnessCenterID() {
        return fitnessCenterID;
    }

    public void setFitnessCenterID(Long fitnessCenterID) {
        this.fitnessCenterID = fitnessCenterID;
    }
}
