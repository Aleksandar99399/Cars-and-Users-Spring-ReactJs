package com.carsandusers.entities;

import javax.persistence.*;

@MappedSuperclass
public class Model {


    private String model;

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public Model setModel(String model) {
        this.model = model;
        return this;
    }
}
