package com.spring.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.dto.VenditoreDTONoPass;
import com.spring.ecommerce.dto.VenditoreDTONoPassProd;
import com.spring.ecommerce.service.VenditoreService;

@RestController
@RequestMapping(path="/servizi")
public class VenditoreController {

	@Autowired
	private VenditoreService service;
	
	@PostMapping(consumes = "application/json")
	public boolean aggiungiVenditore(@RequestBody VenditoreDTO venditore) {
		return service.creaVenditoreVuoto(venditore);
	}
	
	@GetMapping(path="/{idVenditore}", produces = "application/json")
	public VenditoreDTONoPass cercaId(@PathVariable Integer idVenditore) {
		return service.cercaTutto(idVenditore);
	}
	
	@GetMapping(path="cercaSenzaProdotti/{idVenditore}", produces = "application/json")
	public VenditoreDTONoPassProd cerca(@PathVariable Integer idVenditore) {
		return service.cerca(idVenditore);
	}
	
	@PatchMapping(path="/updatePassword/{idVenditore}", produces = "application/json")
	public VenditoreDTO updatePasswordVenditore(@PathVariable Integer idVenditore, String nuovaPassword) {
		return service.modificaPassword(idVenditore, nuovaPassword);
	}
	
	@PostMapping(path="/aggiungi/{idVenditore}", consumes = "application/json")
	public boolean aggiungiProdotto(@PathVariable int idVenditore, @RequestBody ProdottoDTO prodotto) {
		return service.aggiungiProdotto(idVenditore, prodotto);
	}
	
	@PatchMapping(path="/updateQuantita/{idVenditore}")
	public boolean updateQuantitaProdotto(@PathVariable Integer idVenditore, Integer idProdotto, Integer nuovaQuantita) {
		return service.modificaQuantita(idVenditore, idProdotto, nuovaQuantita);
	}
}
