package com.spring.impiegati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.impiegati.dto.ImpiegatoDTO;
import com.spring.impiegati.service.ImpiegatiService;

@RestController
@RequestMapping(path="/impiegati")
public class ImpiegatiController {
	
		@Autowired
		private ImpiegatiService service;
		
		@PostMapping(path="/assumi", consumes = "application/json")
		public boolean assumi(@RequestBody ImpiegatoDTO impiegato) {
			return service.assumi(impiegato);
		}
		
		@GetMapping(path="/cerca/{matricola}", produces = "application/json")
		public ImpiegatoDTO cerca(@PathVariable int matricola) {
			return service.cerca(matricola);
		}
		
		@GetMapping(path="/mostraTutti", produces = "application/json")
		public List<ImpiegatoDTO> cercaTutti() {
			return service.cercaTutti();
		}
		
		@DeleteMapping(path="/cancella/{matricola}", produces = "application/json")
		public ImpiegatoDTO cancella(@PathVariable int matricola) {
			return service.cancella(matricola);
		}
		
		@PutMapping(path="/updateSalario/{matricola}", produces = "application/json")
		public ImpiegatoDTO updateSalario(@PathVariable int matricola, double salarioNuovo) {
			return service.updateSalario(matricola, salarioNuovo);
		}
		
		@DeleteMapping(path="/cancella2/{matricola}", produces = "application/json")
		public String cancellaRNC(@PathVariable int matricola) {
			return service.cancellaRNC(matricola);
		}
		
		@GetMapping(path="/mostraNomi", produces = "application/json")
		public List<String> cercaNominativi() {
			return service.cercaNominativi();
		}
		
		@GetMapping(path="/mostraSalarioMaggiore", produces = "application/json")
		public List<ImpiegatoDTO> salarioMaggiore (double valore) {
			return service.getSalarioMaggiore(valore);
		}
		
		@GetMapping(path="/ordinaCognome", produces = "application/json")
		public List<ImpiegatoDTO> listaOrdinataPerCognome() {
			return service.getOrdinatiByCognome();
		}
		
		@GetMapping(path="/ordinaSalario", produces = "application/json")
		public List<ImpiegatoDTO> listaOrdinataPerSalario() {
			return service.getOrdinatiBySalario();
		}
}
