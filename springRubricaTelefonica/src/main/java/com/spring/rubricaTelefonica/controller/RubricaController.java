package com.spring.rubricaTelefonica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubricaTelefonica.dto.ContattoDTO;
import com.spring.rubricaTelefonica.dto.RubricaDTO;
import com.spring.rubricaTelefonica.service.RubricaService;

@RestController
@RequestMapping(path="/servizi")
public class RubricaController {
	
	@Autowired
	private RubricaService service;
	
	//inserisci nuova rubrica vuota t
	@GetMapping(path="/registra", consumes = "application/json")
	public void inserisciRubrica(@RequestBody RubricaDTO dto) {
		service.inserisciRubrica(dto);
	}
	
	//visualizza rubrica per id
	@GetMapping(path="/visualizzaId/{id}", produces = "application/json")
	public RubricaDTO visualizzaById(@PathVariable int id) {
		return service.visualizzaById(id);
	}
	
	//visualizza tutte le rubriche
	@GetMapping(path="/visualizzaTutti", produces = "application/json")
	public List<RubricaDTO> visualizzaTutti() {
		return service.mostraTutti();
	}
	
	//cancella rubrica
	@GetMapping(path="/cancellaRubrica/{id}")
	public boolean cancellaRubrica(@PathVariable int id) {
		return service.cancellaRubrica(id);
	}
	
	//visualizza solo propietario e anno di creazione rubrica per id
	@GetMapping(path="/visualizzaIdNoList/{id}", produces = "application/json")
	public String visualizzaIdNoList(@PathVariable int id) {
		return service.visualizzaIdNoList(id);
	}
	
	//modifica nome proprietario (torna rubrica)
	@GetMapping(path="/modificaProprietario/{id}", produces = "application/json")
	public RubricaDTO modificaProprietario(@PathVariable int id, String nome) {
		return service.modificaProprietario(id, nome);
	}
	
	//modifica anno di creazione (torna rubrica)
	@GetMapping(path="/modificaAnno/{id}", produces = "application/json")
	public RubricaDTO modificaAnno(@PathVariable int id, int anno) {
		return service.modificaAnno(id, anno);
	}
	
	//visualizza i nomi di tutti i proprietari e il numero di rubriche che hanno
	@GetMapping(path="/visualizzaNumeroRubriche", produces = "application/json")
	public String visualizzaNumeroRubriche() {
		return service.mostraNumeroRubriche();
	}
	//visualizza nome proprietario e anno della rubrica più vecchia
	@GetMapping(path="/visualizzaVecchio", produces = "application/json")
	public String visualizzaVecchio() {
		return service.visualizzavecchio();
	}
	
	//visualizza tutti gli anni di creazione in ordine crescente
	@GetMapping(path="/visualizzaCrescente", produces = "application/json")
	public List<Integer> visualizzaAnniCrescente() {
		return service.mostraAnniCrescente();
	}
	
	//visualizza nome proprietario e il numero di contatti in una rubrica
	@GetMapping(path="/visualizzaNumeroContatti/{id}", produces = "application/json")
	public String visualizzaNumeroContatti(@PathVariable int id) {
		return service.visualizzaNumeroContatti(id);
	}
	
	
	//inserisci nuovo contatto 
	@GetMapping(path="/insersisciContatto/{id}")
	public ContattoDTO inserisciContatto(@PathVariable int id, @RequestBody ContattoDTO contatto) {
		return service.inserisciContatto(id, contatto);
	}
	
	//visualizza contatto per id
	@GetMapping(path="/visualizzaContattoById/{id}", produces = "application/json")
	public ContattoDTO visualizzaContattoById(@PathVariable int idRubrica, int idContatto) {
		return service.mostraContattoById(idRubrica, idContatto);
	}
	
	//modifica contatto esistente (tutti i campi tranne id)
	@GetMapping(path="/modificaContatto/{id}", consumes = "application/json", produces = "application/json")
	public ContattoDTO modificaContatto(@PathVariable int id, @RequestBody ContattoDTO contatto) {
		return service.modificaContatto(id, contatto);
	}
	
	//cancella un contatto
	@GetMapping(path="/cancellaContatto/{id}")
	public boolean cancellaContatto(@PathVariable int idRubrica, int idContatto) {
		return service.cancellaContatto(idRubrica, idContatto);
	}
	
	//visualizza tutti i contatti data una rubrica
	@GetMapping(path="/viaulizzaContattiRUbrica/{id}", produces = "application/json")
	public List<ContattoDTO> visualizzaContattiRubrica(@PathVariable int id) {
		return service.visualizzaContattiRUbrica(id);
	}
	
	//visualizza il numero di contatti di una rubrica
	@GetMapping(path="/visualizzaContattiSingolo/{id}")
	public int visualizzaNumeroContattiSingolo(@PathVariable int id) {
		return service.contaContatti(id);
	}
	
	//visualizza un contatto dato un numero
	@GetMapping(path="/visualizzaContattoByNumero/{id}", produces = "application/json")
	public List<ContattoDTO> visualizzaContattoByNumero(@PathVariable int idRubrica, String numero) {
		return service.mostraContattoByNumero(idRubrica, numero);
	}
	
	//visualizza nome e cognome dato un gruppo
	@GetMapping(path="/visualizzaNomeByGruppo/{id}", produces = "application/json")
	public List<String> visualizzaNomeByGruppo(@PathVariable int idRubrica, String gruppo) {
		return service.mostraNomeByGruppo(idRubrica, gruppo);
	}
	
	//ricerca il numero di contatti dato un gruppo
	@GetMapping(path="/visualizzanNumeroByGruppo/{id}")
	public int visualizzanNumeroByGruppo(@PathVariable int idRubrica, String gruppo) {
		return service.mostraNumeroByGruppo(idRubrica, gruppo);
	}
	
	//cancella tutti i contatti di un gruppo
	@GetMapping(path="/cancellaByGruppo/{id}")
	public void cancellaByGruppo(@PathVariable int idRubrica, String gruppo) {
		service.cancellabyGruppo(idRubrica, gruppo);
	}
	//assegna un contatto da non preferito a preferito
	@GetMapping(path="/assegnaPreferito/{id}")
	public boolean assegnaPreferito(@PathVariable int idRubrica, int idContatto) {
		return service.assegnaPreferito(idRubrica, idContatto);
	}
	
	//visualizza preferiti
	@GetMapping(path="/visualizzaPreferiti/{id}", produces = "application/json")
	public List<ContattoDTO> visualizzaPreferiti(@PathVariable int id) {
		return service.visualizzaPreferiti(id);
	}
}
