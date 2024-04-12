package com.bci.prueba.dtomodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.bci.prueba.model.Phone;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest implements Serializable {
  private long id;
	@NotNull
	private String name;
	@Email
	@NotNull(message = "El correo tiene un formato Incorrecto")
	private String email;
	@NotNull
	private String password;
  private List<Phone> phones = new ArrayList<>();
}
