package com.mendev.CharterManager.repository;

import com.mendev.CharterManager.model.Customer;

import com.mendev.CharterManager.model.Reservation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer deleteById(long id);

    Customer save(Customer customer);

    Customer getById(int id);

    Customer getReferenceById(int id);

    Customer findById(int id);

    @Override
    <S extends Customer> List<S> findAll(Example<S> example);
}
