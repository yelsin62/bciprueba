package com.bci.prueba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bci.prueba.model.Phone;
public interface PhoneRepository extends JpaRepository<Phone,Integer>{

}
