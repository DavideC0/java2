package com.example.es1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.es1.entity.Utente;


@RestController
@RequestMapping(path="/gestioneUtenti")
public class UtenteController {

	@GetMapping(path="/carica", consumes = "application/json")
	public boolean registra(@RequestBody Utente utente) {
		System.out.println("Ho registrato" + utente);
		return true;
	}
	
	@GetMapping(path="/cerca/{id}", produces = "application/json")
	public Utente cerca(@PathVariable int id) {
		return new Utente(id, "anna", "pepe", "anna", "111", 1998);
	}
	
	@GetMapping(path="/modifica/{id}", produces = "application/json")
	public Utente modificaPass(@PathVariable int id, String password) {
		return new Utente(id, "anna", "pepe", "anna", password, 1998);
	}
	
}
