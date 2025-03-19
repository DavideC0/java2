package com.spring.contoCorrente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.contoCorrente.dto.UtenteDTO;
import com.spring.contoCorrente.service.UtenteService;

@RestController
@RequestMapping(path="/serviziUtente")
public class UtenteController {

	@Autowired
	private UtenteService service;
	
	@GetMapping(path="/registra", consumes = "application/json")
	public void insertUtente(@RequestBody UtenteDTO dto) {
		service.insert(dto);
	}
	
	@GetMapping(path="/update", consumes = "application/json")
	public void updateUtente(@RequestBody UtenteDTO dto) {
		service.update(dto);
	}
	
	@GetMapping(path="/delete/{id}")
	public void deleteUtente(@PathVariable int id) {
		service.delete(id);
	}
	
	@GetMapping(path="/selectId/{id}", produces = "application/json")
	public UtenteDTO selectById(@PathVariable int id) {
		return service.selectById(id);
	}
	
	@GetMapping(path="/selectAll", produces = "application/json")
	public List<UtenteDTO> selectAll() {
		return service.selectAll();
	}
}
