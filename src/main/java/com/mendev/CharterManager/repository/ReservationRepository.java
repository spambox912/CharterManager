package com.mendev.CharterManager.repository;

import com.mendev.CharterManager.controller.ReservationController;
import com.mendev.CharterManager.model.Reservation;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long> {

    List<Reservation> findAll();

    //Page<Reservation> findAll(Pageable page);

    Reservation save(Reservation reservation);

    Reservation getById(int id);

    Reservation deleteById(long id);

    @Override
    <S extends Reservation> List<S> findAll(Example<S> example);

    Reservation getReferenceById(int id);


}
