package com.bci.prueba.service.Impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.prueba.dtomodel.PersonRequest;
import com.bci.prueba.dtomodel.PersonResponse;
import com.bci.prueba.model.Person;
import com.bci.prueba.model.Phone;
import com.bci.prueba.repository.PersonRepository;
import com.bci.prueba.repository.PhoneRepository;
import com.bci.prueba.service.PersonService;
import com.bci.prueba.util.TokenService;

@Service
public class PersonServiceImpl  implements PersonService{

  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private PhoneRepository phoneRepository;

  @Override
  public PersonResponse savePerson(PersonRequest request) throws Exception {

    Person personSearch=personRepository.getPersonByEmail(request.getEmail());

    if(personSearch != null) {
      throw new Exception("El correo ya registrado");
    }

    UUID uuid = UUID.randomUUID();
    Person person = Person.builder()
    .name(request.getName())
    .email(request.getEmail())
    .password(request.getPassword())
    .created(LocalDate.now())
    .lastLogin(LocalDate.now())
    .isactive(1)
    .build();

    personRepository.save(person);

    request.getPhones().forEach(phone -> {
      Phone phoneSave = Phone.builder()
      .number(phone.getNumber())
      .citycode(phone.getCitycode())
      .contrycode(phone.getContrycode())
      .person(person)
      .build();
      phoneRepository.save(phoneSave);
    });
    TokenService tokenService = new TokenService();
    
    PersonResponse response = PersonResponse.builder()
    .id(uuid)
    .created(person.getCreated())
    .modified(person.getModified())
    .lastLogin(person.getLastLogin())
    .isactive(person.getIsactive())
    .token(tokenService.generateToken(person.getEmail()))
    .build();

    return response;
  }

}
