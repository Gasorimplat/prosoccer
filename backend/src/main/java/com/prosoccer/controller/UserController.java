package com.prosoccer.controller;

import com.prosoccer.model.Jugador;
import com.prosoccer.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private JugadorRepository jugadorRepository;

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Jugador user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		jugadorRepository.save(user);
	}
}
