package com.mendev.CharterManager.repository;

import com.mendev.CharterManager.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlReservationRepository extends ReservationRepository, JpaRepository<Reservation, Long> {
}
