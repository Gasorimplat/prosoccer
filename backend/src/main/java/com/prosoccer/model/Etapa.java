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
public class Etapa implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private TipoEtapa tipoEtapa;

	@OneToMany(mappedBy = "id")
	private List<Grupo> grupos;

	@OneToMany(mappedBy = "id")
	private List<Fixture> fixtures;

}
