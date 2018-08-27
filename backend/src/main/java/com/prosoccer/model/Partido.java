package com.prosoccer.model;

import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Partido implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private DateTime fecha;

	private Planilla local;

	private Cancha cancha;

	private Planilla visitante;

	private Resultado resultado;
}
