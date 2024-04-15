package com.bci.prueba.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bci.prueba.dtomodel.PersonRequest;
import com.bci.prueba.dtomodel.PersonResponse;
import com.bci.prueba.model.Person;
import com.bci.prueba.model.Phone;
import com.bci.prueba.repository.PersonRepository;
import com.bci.prueba.repository.PhoneRepository;
import com.bci.prueba.service.Impl.PersonServiceImpl;
import com.bci.prueba.util.TokenService;

@ExtendWith(MockitoExtension.class) 
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePerson_HappyPath() throws Exception {
        // Arrange
        PersonRequest request = new PersonRequest();
        request.setName("Yelsin Ramirez");
        request.setEmail("yramirel@emeal.nttdata.com");
        request.setPassword("yramirel");

        List<Phone> phones = new ArrayList<>();
        Phone phone = Phone.builder().number("985478562").citycode("1").contrycode("1").build();
        phones.add(phone);
        request.setPhones(phones);

        when(personRepository.getPersonByEmail(request.getEmail())).thenReturn(null);

        Person savedPerson = new Person();
        savedPerson.setEmail(request.getEmail());
        savedPerson.setCreated(LocalDate.now());

        when(personRepository.save(any(Person.class))).thenReturn(savedPerson);

        // Act
        PersonResponse response = personService.savePerson(request);

        // Assert
        assertEquals(savedPerson.getCreated(), response.getCreated());
    }

    @Test
    void testSavePerson_UnhappyPath_EmailAlreadyRegistered() {
        // Arrange
        String existingEmail = "yramirel@emeal.nttdata.com";
        
        PersonRequest request = new PersonRequest();
        request.setEmail(existingEmail);
        
        
        Person existingPerson = new Person();
        existingPerson.setEmail(existingEmail);
        
        when(personRepository.getPersonByEmail(existingEmail)).thenReturn(existingPerson);

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            personService.savePerson(request);
        });

        // Verify
        assertEquals("El correo ya registrado", exception.getMessage());
    }
}