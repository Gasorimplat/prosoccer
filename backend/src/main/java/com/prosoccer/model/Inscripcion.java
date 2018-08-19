package com.prosoccer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Currency;

@Entity
@Data
public class Inscripcion implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private Torneo torneo;

	private Equipo equipo;

	private Currency saldo;
}
