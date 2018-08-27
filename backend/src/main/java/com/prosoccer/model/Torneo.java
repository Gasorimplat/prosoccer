package com.prosoccer.model;

import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Torneo implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String nombre;

	private DateTime fecha;

	@OneToMany(mappedBy = "id")
	private List<Etapa> etapas;
}
