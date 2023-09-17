package com.mendev.CharterManager.repository;

import com.mendev.CharterManager.model.Customer;
import com.mendev.CharterManager.model.Yacht;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YachtRepository extends JpaRepository<Yacht, String> {

    //Yacht deint idleteById();

    Yacht save(Yacht yacht);

    //Yacht getById(int id);

    //Yacht getReferenceById(int id);

    //Yacht findById(int id);

    @Override
    <S extends Yacht> List<S> findAll(Example<S> example);
}
