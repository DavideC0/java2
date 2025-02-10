package com.spring.universita.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.service.StudenteService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path="/serviziStudente")
public class StudenteController {
	
	private StudenteService service = new StudenteService();
	
	//registra studente
	@GetMapping(path="/registra", consumes = "application/json", produces = "application/json")
	public StudenteDTO getMethodName(@RequestBody StudenteDTO studente) {
		return service.registra(studente);
	}
	
	//cerca studente per matricola
	@GetMapping(path="/visualizzaId/{matricola}", produces = "application/json")
	public StudenteDTO visualizzaId(@PathVariable String matricola) {
		return service.visualizzaId(matricola);
	}
	
	//visualizza tutti gli studenti
	@GetMapping(path="/visualizzaTutti", produces = "application/json")
	public List<StudenteDTO> visualizzaTutti() {
		return service.mostraTutti();
	}
	//cancella uno studente per matricola
	@GetMapping(path="/cancella/{matricola}")
	public boolean cancela(@PathVariable String matricola) {
		return service.cancella(matricola);
	}
		
	//modifica indirizzo studente
	@GetMapping(path="/modifica/{matricola}", produces = "application/json")
	public StudenteDTO modifica(@PathVariable String matricola, String indirizzo) {
		return service.modifica(matricola, indirizzo);
	}

}
