package com.spring.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class VenditoreDTONoPass {
	private int id;
	private String nome, cognome, username, via, citta;
	private List<ProdottoDTO> prodotti = new ArrayList<ProdottoDTO>();
	
	public VenditoreDTONoPass() {
		// TODO Auto-generated constructor stub
	}

	public VenditoreDTONoPass(int id, String nome, String cognome, String username, String via, String citta,
			List<ProdottoDTO> prodotti) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.via = via;
		this.citta = citta;
		this.prodotti = prodotti;
	}

	public VenditoreDTONoPass(int id, String nome, String cognome, String username, String via, String citta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.via = via;
		this.citta = citta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public List<ProdottoDTO> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<ProdottoDTO> prodotti) {
		this.prodotti = prodotti;
	}
	
	
}
