package com.spring.rubricaTelefonica.dto;

import java.util.ArrayList;
import java.util.List;

public class RubricaDTO {
	
	private int id;
	private String proprietario;
	private List<ContattoDTO> contatti = new ArrayList<ContattoDTO>();
	private int annoCreazione;
	public RubricaDTO(int id, String proprietario, List<ContattoDTO> contatti, int annoCreazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.contatti = contatti;
		this.annoCreazione = annoCreazione;
	}
	public RubricaDTO(int id, String proprietario, int annoCreazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
		this.contatti = new ArrayList<ContattoDTO>();
	}
	
	public RubricaDTO() {
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
	public List<ContattoDTO> getContatti() {
		return contatti;
	}
	public void setContatti(List<ContattoDTO> contatti) {
		this.contatti = contatti;
	}
	public int getAnnoCreazione() {
		return annoCreazione;
	}
	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	

}
