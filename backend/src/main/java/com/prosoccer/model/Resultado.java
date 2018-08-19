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
public class Resultado implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private Integer golesLocal;

	private Integer golesVisitante;

	@OneToMany(mappedBy = "id")
	private List<Suceso> sucesos;

}
