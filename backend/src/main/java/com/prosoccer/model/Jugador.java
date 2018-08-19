package com.prosoccer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Jugador implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String nombre;

	private String apellido;

	private String documento;

	private String telefono;
}
