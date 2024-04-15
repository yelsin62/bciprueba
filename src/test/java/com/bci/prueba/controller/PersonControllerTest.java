package com.bci.prueba.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bci.prueba.dtomodel.PersonRequest;
import com.bci.prueba.dtomodel.PersonResponse;
import com.bci.prueba.model.Person;
import com.bci.prueba.model.Phone;
import com.bci.prueba.repository.PersonRepository;
import com.bci.prueba.repository.PhoneRepository;
import com.bci.prueba.service.PersonService;
import com.bci.prueba.service.Impl.PersonServiceImpl;
import com.bci.prueba.util.TokenService;
import com.bci.prueba.util.Error;
@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {
  @Mock
  private PersonService personService;

  @InjectMocks
  private PersonContoller personController;

  @BeforeEach
  public void initMocks() {
      MockitoAnnotations.initMocks(this);
  }

  @Test
  @DisplayName("Happy Path: Guardar Persona")
  public void testSavePerson_HappyPath() throws Exception {
      // Arrange
      PersonRequest request = new PersonRequest();

      PersonResponse expectedResponse = new PersonResponse();

      when(personService.savePerson(request)).thenReturn(expectedResponse);

      // Act
      ResponseEntity<?> responseEntity = personController.savePerson(request);

      // Assert
      assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
      assertEquals(expectedResponse, responseEntity.getBody());
  }

  @Test
  @DisplayName("Unhappy Path: Error al Guardar Persona")
  public void testSavePerson_UnhappyPath() throws Exception {
      // Arrange
      PersonRequest request = new PersonRequest();

      String errorMessage = "Error message";
      when(personService.savePerson(request)).thenThrow(new Exception(errorMessage));

      // Act
      ResponseEntity<?> responseEntity = personController.savePerson(request);

      // Assert
      assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
      assertEquals(Error.class, responseEntity.getBody().getClass());
      assertEquals(errorMessage, ((Error)responseEntity.getBody()).getMensaje());
  }
}
