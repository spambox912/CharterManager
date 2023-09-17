package com.mendev.CharterManager.model;

import com.mendev.CharterManager.repository.CustomerRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="reservations")
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Customer must not be empty")
    @ManyToOne
    private Customer customer;

    @NotBlank(message = "Yacht must not be empty")
    @ManyToOne
    private Yacht yacht;

    @NotNull(message = "Date from must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be future or present")
    private LocalDate reservationFrom;

    @NotNull(message = "Date to must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be future or present")
    private LocalDate reservationTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Yacht getYacht() {
        return yacht;
    }

    public void setYacht(Yacht yacht) {
        this.yacht = yacht;
    }

    public LocalDate getReservationFrom() {
        return reservationFrom;
    }

    public void setReservationFrom(LocalDate reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    public LocalDate getReservationTo() {
        return reservationTo;
    }

    public void setReservationTo(LocalDate reservationTo) {
        this.reservationTo = reservationTo;
    }

    public Reservation() {
    }

    public Reservation(int id, Customer customer, Yacht yacht, LocalDate reservationFrom, LocalDate reservationTo) {
        this.id = id;
        this.customer = customer;
        this.yacht = yacht;
        this.reservationFrom = reservationFrom;
        this.reservationTo = reservationTo;
    }


}
