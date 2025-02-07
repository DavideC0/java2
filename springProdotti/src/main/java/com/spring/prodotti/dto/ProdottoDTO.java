package com.spring.prodotti.dto;

public class ProdottoDTO {
	private int id,quantita;
	private String marca, modello, descrizione, categoria;
	private double prezzo_cons, prezzo_max;
	public ProdottoDTO(int id, int quantita, String marca, String modello, String descrizione, String categoria,
			double prezzo_cons, double prezzo_max) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.prezzo_cons = prezzo_cons;
		this.prezzo_max = prezzo_max;
	}
	public ProdottoDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
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
	public double getPrezzo_cons() {
		return prezzo_cons;
	}
	public void setPrezzo_cons(double prezzo_cons) {
		this.prezzo_cons = prezzo_cons;
	}
	public double getPrezzo_max() {
		return prezzo_max;
	}
	public void setPrezzo_max(double prezzo_max) {
		this.prezzo_max = prezzo_max;
	}
	
	
}
