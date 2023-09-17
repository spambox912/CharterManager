package com.mendev.CharterManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name="yachts")
@Table(name="yachts")

public class Yacht {

    @Id
    private String registrationNumber;
    @NotBlank(message = "Yacht's name must not be empty")
    private String name;
    @NotBlank(message = "Yacht's type must not be empty")
    private String type;
    @NotNull(message = "Yacht's length must not be empty")
    private double length;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Yacht() {
    }

    public Yacht(String registrationNumber, String name, String type, double length) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.type = type;
        this.length = length;
    }
}
