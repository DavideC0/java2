package com.spring.rubricaTelefonica.entity;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	
	private int id;
	private String proprietario;
	private List<Contatto> contatti = new ArrayList<Contatto>();
	private int annoCreazione;
	public Rubrica(int id, String proprietario, List<Contatto> contatti, int annoCreazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.contatti = contatti;
		this.annoCreazione = annoCreazione;
	}
	public Rubrica(int id, String proprietario, int annoCreazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
		this.contatti = new ArrayList<Contatto>();
	}
	public Rubrica() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public List<Contatto> getContatti() {
		return contatti;
	}
	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}
	public int getAnnoCreazione() {
		return annoCreazione;
	}
	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	
	public void addContatto(Contatto contatto) {
		this.contatti.add(contatto);
	}
	
	
}
