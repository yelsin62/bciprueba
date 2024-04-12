package com.bci.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bci.prueba.model.Person;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{

  Person getPersonByEmail(String email);
}
