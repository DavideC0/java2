package com.spring.rubricaTelefonica.entity;

public class Contatto {
	
	private int id;
	private String nome, cognome, numero, gruppo, dataNascita;
	private boolean preferito;
	public Contatto(int id, String nome, String cognome, String numero, String gruppo, String dataNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.dataNascita = dataNascita;
		this.preferito = false;
	}
	public Contatto() {
		super();
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getGruppo() {
		return gruppo;
	}
	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public boolean isPreferito() {
		return preferito;
	}
	public void setPreferito(boolean preferito) {
		this.preferito = preferito;
	}
	
}
