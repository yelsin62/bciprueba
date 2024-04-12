package com.bci.prueba.dtomodel;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonResponse {
  private UUID id;
	private LocalDate created;
	private LocalDate modified;
	private LocalDate lastLogin;
	private Integer isactive;
	private String token;
}
