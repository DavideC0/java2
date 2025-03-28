package com.spring.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prodotto {

	@Id
	private int id;
	private String descrizione, categoria;
	private double prezzo_unitario;
	private int sconto, quantita;
	
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}

	

	public Prodotto(int id, String descrizione, String categoria, double prezzo_unitario, int sconto, int quantita) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.prezzo_unitario = prezzo_unitario;
		this.sconto = sconto;
		this.quantita = quantita;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo_unitario() {
		return prezzo_unitario;
	}

	public void setPrezzo_unitario(double prezzo_unitario) {
		this.prezzo_unitario = prezzo_unitario;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
}
