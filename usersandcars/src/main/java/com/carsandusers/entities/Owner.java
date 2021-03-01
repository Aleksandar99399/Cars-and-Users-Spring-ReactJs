package com.carsandusers.entities;

import javax.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {

    private long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public Owner setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Owner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Owner setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Owner setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    @Column(name = "email",unique = true)
    public String getEmail() {
        return email;
    }

    public Owner setEmail(String email) {
        this.email = email;
        return this;
    }
}
