package com.bci.prueba.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "created")
	private LocalDate created;

	@Column(name = "modified")
	private LocalDate modified;

	@Column(name = "last_login")
	private LocalDate lastLogin;

	@Column(name = "isactive")
	private Integer isactive;

	@Column(name = "token")
	private String token;


}
