package com.carsandusers.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Brand{

    private long id;
    private Owner owner;
    private String registrationNumber;
    private String color;
    private String hp;


    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }

    @ManyToOne
    public Owner getOwner() {
        return owner;
    }

    public Car setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }



    @Column(name = "reg_number")
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Car setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    @Column(name = "hp")
    public String getHp() {
        return hp;
    }

    public Car setHp(String hp) {
        this.hp = hp;
        return this;
    }


}
