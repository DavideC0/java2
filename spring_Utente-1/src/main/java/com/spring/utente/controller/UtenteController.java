package com.spring.utente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.service.UtenteService;

@RestController
@RequestMapping(path="/servizi")
public class UtenteController {

	private UtenteService service = new UtenteService();
	
	@GetMapping(path="/registra", consumes = "application/json")
	public void registra(@RequestBody UtenteDTO dto) {
		service.registra(dto);
	}
	
	@GetMapping(path="/cerca/{id}", produces = "application/json")
	public UtenteDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="/mostraTutti", produces="application/json")
	public List<UtenteDTO> mostraTutti(){
		return service.mostraTutti();
	}
	
	//cancellazione tramite id
	@GetMapping(path="/cancella/{id}", consumes="application/json")
	public boolean cancellaPerId(@PathVariable int id) {
		return service.cancella(id);
	}
	
	//modifica password
	@GetMapping(path="/modificaPass/{id}")
	public UtenteDTO aggiornaPassword(@PathVariable int id, String password) {
		return service.modificaPassword(id, password);
	}
	
	//modifica utente
	@GetMapping(path="/modificaUtente", consumes="application/json")
	public void aggiornaUtente(@RequestBody UtenteDTO utenteDto) {
		service.modificaUtente(utenteDto);
	}
	
	//ritorna lista solo nomi
	@GetMapping(path="/listaNomi", produces = "application/json")
	public List<String> mostraNomi(){
		return service.mostraNomi();
	}
	
	//ritorna solo nomi E cognomi
	@GetMapping(path="/listaNomiCognomi", produces="application/json")
	public List<String> mostraNomiECognomi(){
		return service.mostraNomiECognomi();
	}

}