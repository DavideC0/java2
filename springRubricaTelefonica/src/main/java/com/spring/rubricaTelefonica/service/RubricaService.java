package com.spring.rubricaTelefonica.service;

import java.util.List;

import com.spring.rubricaTelefonica.dto.ContattoDTO;
import com.spring.rubricaTelefonica.dto.RubricaDTO;

public interface RubricaService {
	
	public void inserisciRubrica(RubricaDTO dto);

	public RubricaDTO visualizzaById(int id);

	public List<RubricaDTO> mostraTutti();

	public boolean cancellaRubrica(int id);

	public String visualizzaIdNoList(int id);

	public RubricaDTO modificaProprietario(int id, String nome);

	public RubricaDTO modificaAnno(int id, int anno);

	public String mostraNumeroRubriche();

	public String visualizzavecchio();

	public List<Integer> mostraAnniCrescente();

	public String visualizzaNumeroContatti(int id);

	public ContattoDTO inserisciContatto(int id, ContattoDTO contatto);

	public ContattoDTO mostraContattoById(int idRubrica, int idContatto);

	public ContattoDTO modificaContatto(int id, ContattoDTO contatto);

	public boolean cancellaContatto(int idRubrica, int idContatto);

	public List<ContattoDTO> visualizzaContattiRUbrica(int id);

	public int contaContatti(int id);

	public List<ContattoDTO> mostraContattoByNumero(int idRubrica, String numero);

	public List<String> mostraNomeByGruppo(int idRubrica, String gruppo);

	public int mostraNumeroByGruppo(int idRubrica, String gruppo);

	public void cancellabyGruppo(int idRubrica, String gruppo);

	public boolean assegnaPreferito(int idRubrica, int idContatto);

	public List<ContattoDTO> visualizzaPreferiti(int id);

}
