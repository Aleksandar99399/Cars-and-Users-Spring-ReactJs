package com.carsandusers.dto;

import com.carsandusers.entities.Brand;
import com.carsandusers.entities.Model;
import com.carsandusers.entities.Owner;

public class CarDto {

    private long id;
    private Owner owner;
    private String brand;
    private String model;
    private String registrationNumber;
    private String color;
    private String hp;


    public long getId() {
        return id;
    }

    public CarDto setId(long id) {
        this.id = id;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public CarDto setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CarDto setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarDto setColor(String color) {
        this.color = color;
        return this;
    }

    public String getHp() {
        return hp;
    }

    public CarDto setHp(String hp) {
        this.hp = hp;
        return this;
    }
}
