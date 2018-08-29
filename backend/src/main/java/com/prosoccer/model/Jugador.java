package com.prosoccer.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Jugador implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String apellido;

	private String telefono;

	//Se maneja nro de documento como username
	private String username;

	private String password;
}
