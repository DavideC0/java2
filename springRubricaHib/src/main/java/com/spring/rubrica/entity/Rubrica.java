package com.spring.rubrica.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Rubrica {

	@Id
	private int idRubrica;
	private String proprietario;
	private int anno;
	
	@OneToMany
	@JoinColumn(name="FK_Rubrica")
	private List<Contatto> contatti = new ArrayList<Contatto>();
	
	public Rubrica() {
		// TODO Auto-generated constructor stub
	}

	public Rubrica(int idRubrica, String proprietario, int anno, List<Contatto> contatti) {
		super();
		this.idRubrica = idRubrica;
		this.proprietario = proprietario;
		this.anno = anno;
		this.contatti = contatti;
	}

	public Rubrica(int idRubrica, String proprietario, int anno) {
		super();
		this.idRubrica = idRubrica;
		this.proprietario = proprietario;
		this.anno = anno;
	}

	public int getIdRubrica() {
		return idRubrica;
	}

	public void setIdRubrica(int idRubrica) {
		this.idRubrica = idRubrica;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public List<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}
	
	public void aggiungi(Contatto contatto) {
		this.contatti.add(contatto);
	}
}
