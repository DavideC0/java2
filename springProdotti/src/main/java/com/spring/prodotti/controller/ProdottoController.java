package com.spring.prodotti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.dto.ReportDTO;
import com.spring.prodotti.service.ProdottoService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="/servizi")
public class ProdottoController {
	
	private ProdottoService service = new ProdottoService();
	
	//registra prodotto
	@GetMapping(path="/inserisci")
	public ProdottoDTO registra(@RequestBody ProdottoDTO prodotto) {
		return service.registra(prodotto);
	}
	
	//visualizza prodotti
	@GetMapping(path="/visualizzaTutti", produces = "application/json")
	public List<ProdottoDTO> visualizzaTutti() {
		return service.mostraTutti();
	}
	
	
	//visualizza prodotto per id
	@GetMapping(path="/visualizzaId/{id}", produces = "application/json")
	public ProdottoDTO visualizzaId(@PathVariable int id) {
		return service.visualizzaId(id);
	}
	
	
	//visualizza report
	@GetMapping(path="/visualizzaReport", produces = "application/json")
	public ReportDTO VisualizzaReport() {
		return service.visualizzaReport();
	}
	
}
