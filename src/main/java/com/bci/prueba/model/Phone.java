package com.bci.prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phone")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Phone {
  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "citycode")
	private String citycode;

	@Column(name = "contrycode")
	private String contrycode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;
}
