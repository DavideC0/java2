package com.spring.rubrica.dto;

import java.util.ArrayList;
import java.util.List;

public class RubricaDTO {
	
	private int idRubrica;
	private String proprietario;
	private int anno;
	private List<ContattoDTO> contatti = new ArrayList<ContattoDTO>();
	
	public RubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaDTO(int idRubrica, String proprietario, int anno, List<ContattoDTO> contatti) {
		super();
		this.idRubrica = idRubrica;
		this.proprietario = proprietario;
		this.anno = anno;
		this.contatti = contatti;
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

	public List<ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(List<ContattoDTO> contatti) {
		this.contatti = contatti;
	}
	
	

}
