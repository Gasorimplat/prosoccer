package com.prosoccer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Grupo implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private Integer numero;

	@OneToMany(mappedBy = "id")
	private List<Equipo> equipos;
}
