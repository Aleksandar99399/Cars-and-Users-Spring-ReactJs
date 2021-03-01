package com.carsandusers.entities;

import javax.persistence.*;

@MappedSuperclass
public class Brand extends Model{

    private String brand;

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public Brand setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
