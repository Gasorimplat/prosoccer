package com.prosoccer.repository;

import com.prosoccer.model.Jugador;
import org.springframework.data.repository.CrudRepository;

public interface JugadorRepository extends CrudRepository<Jugador, Long> {
	Jugador findByUsername(String documento);
	Jugador findByUsernameAndPassword(String documento, String password);
}
