package com.bci.prueba.service;

import java.util.Map;

import com.bci.prueba.dtomodel.PersonRequest;
import com.bci.prueba.dtomodel.PersonResponse;

public interface PersonService {
  public PersonResponse savePerson(PersonRequest request) throws Exception;
}
