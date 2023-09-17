package com.mendev.CharterManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name="customers")
@Table(name="customers")
//@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Customer's first name must not be empty")
    private String firstName;
    @NotBlank(message = "Customer's last name must not be empty")
    private String lastName;
    @NotBlank(message = "Customer's email must not be empty")
    private String email;
    @NotBlank(message = "Customer's phone must not be empty")
    private String phone;
    @NotBlank(message = "Customer's licence must not be empty")
    private String licenceNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String phone, String licenceNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.licenceNumber = licenceNumber;
    }
}
