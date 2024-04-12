package com.bci.prueba.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.prueba.dtomodel.PersonRequest;
import com.bci.prueba.dtomodel.PersonResponse;
import com.bci.prueba.service.PersonService;
import com.bci.prueba.util.Error;

import jakarta.validation.Valid;

@RestController  
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class PersonContoller {

  @Autowired
	private PersonService service;

  @PostMapping("/person")
	public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonRequest personDTO) throws Exception{
		PersonResponse response;
		try {			
			response = service.savePerson(personDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body( response );
		 } catch (Exception e) {
			return ResponseEntity.badRequest().body(new Error(e.getMessage()));
		}
	    
	}
}
