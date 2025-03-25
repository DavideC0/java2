package com.spring.studente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studente.dto.StudenteDTO;
import com.spring.studente.service.StudenteService;

@RestController
@RequestMapping(path="/studenti")
public class StudenteController {

	@Autowired
	private StudenteService service;
	
	@PostMapping(consumes="application/json")
	public boolean immatricola(@RequestBody StudenteDTO dto) {
		return service.immatricola(dto);
	}
	
	@GetMapping(path="/{matricola}", produces = "application/json")
	public StudenteDTO cerca(@PathVariable int matricola) {
		return service.cerca(matricola);
	}
	
	@GetMapping(path="/mostraTutti", produces = "application/json")
	public List<StudenteDTO> mostraTutti() {
		return service.cercaTutti();
	}
	
	@PostMapping(path="/cancella/{matricola}", produces = "application/json")
	public StudenteDTO cancella(@PathVariable int matricola) {
		return service.cancella(matricola);
	}
	
	@GetMapping(produces = "application/json")
	public List<StudenteDTO> getGiovani(int anno) {
		return service.getGiovani(anno);
	}
}
