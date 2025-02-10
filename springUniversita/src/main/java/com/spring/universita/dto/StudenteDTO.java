package com.spring.universita.dto;

public class StudenteDTO {
	
	private String matricola, nome, cognome, indirizzo;
	private int annoNascita, annoImmatricolazione;
	public StudenteDTO(String matricola, String nome, String cognome, String indirizzo, int annoNascita,
			int annoImmatricolazione) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.annoNascita = annoNascita;
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public StudenteDTO() {
		super();
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
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
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	@Override
	public String toString() {
		return "StudenteDTO [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo="
				+ indirizzo + ", annoNascita=" + annoNascita + ", annoImmatricolazione=" + annoImmatricolazione + "]";
	}
	

}
