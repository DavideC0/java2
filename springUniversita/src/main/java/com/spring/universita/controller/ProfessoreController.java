package com.spring.universita.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.service.ProfessoreService;

@RestController
@RequestMapping(path="/serviziProf")
public class ProfessoreController {
	
	private ProfessoreService service = new ProfessoreService();
	
	//registra professore
	@GetMapping(path="/registra", produces = "application/json", consumes = "application/json")
	public ProfessoreDTO registra(@RequestBody ProfessoreDTO professore) {
		return service.registra(professore);
	}
	
	//cerca professore per id
	@GetMapping(path="/visualizzaId/{id}", produces = "application/json")
	public ProfessoreDTO visualizzaId(@PathVariable int id) {
		return service.visualizzaId(id);
	}
	
	//visualizza tutti i professori
	@GetMapping(path="/visualizzaTutti", produces = "application/json")
	public List<ProfessoreDTO> visualizzaTutti() {
		return service.mostraTutti();
	}
	
	//cancella un professore per id
	@GetMapping(path="/cancella/{id}")
	public boolean cancella(@PathVariable int id) {
		return service.cancella(id);
	}
	
	//modifica materia del professore per id
	@GetMapping(path="/modifica/{id}", produces = "application/json")
	public ProfessoreDTO modifica(@PathVariable int id, String materia) {
		return service.modifica(id, materia);
	}
	
}
