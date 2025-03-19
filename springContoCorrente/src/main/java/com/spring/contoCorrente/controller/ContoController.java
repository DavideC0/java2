package com.spring.contoCorrente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.contoCorrente.dto.ContoDTO;
import com.spring.contoCorrente.service.ContoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="/serviziConto")
public class ContoController {
	
	@Autowired
	private ContoService service;
	
	@GetMapping(path="/registra", consumes = "application/json")
	public void insertConto(@RequestBody ContoDTO dto) {
		service.insert(dto);
	}
	
	@GetMapping(path="/prelievo/{id}")
	public void prelievoConto(@PathVariable int id, int quantita) {
		service.prelievo(id, quantita);
	}
	
	@GetMapping(path="/versamento/{id}")
	public void versamentoConto(@PathVariable int id, int quantita) {
		service.versamento(id, quantita);
	}
	
	@GetMapping(path="/saldo/{id}")
	public int getSaldoConto(@PathVariable int id) {
		return service.getSaldo(id);
	}
	
	@GetMapping(path="/movimenti/{id}", produces = "application/json")
	public List<Integer> getMovimenti(@PathVariable int id) {
		return service.getMovimenti(id);
	}
	
	
}
