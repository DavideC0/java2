package com.spring.rubricaTelefonica.utility;

import java.util.ArrayList;
import java.util.List;

import com.spring.rubricaTelefonica.dto.ContattoDTO;
import com.spring.rubricaTelefonica.dto.RubricaDTO;
import com.spring.rubricaTelefonica.entity.Contatto;
import com.spring.rubricaTelefonica.entity.Rubrica;

public class Conversioni {
	
	public static Contatto daContattoDTOAContatto(ContattoDTO dto) {
		return new Contatto(dto.getId(),dto.getNome(), dto.getCognome(), dto.getNumero(), dto.getGruppo(), dto.getDataNascita());
	}
	
	public static ContattoDTO daContattoAContattoDTO(Contatto entity) {
		return new ContattoDTO(entity.getId(),entity.getNome(), entity.getCognome(), entity.getNumero(), entity.getGruppo(), entity.getDataNascita());
	}
	
	public static RubricaDTO daRubricaARubricaDTO(Rubrica rubrica) {
		List<ContattoDTO> lista_dto = new ArrayList<ContattoDTO>();
		for (Contatto contatto: rubrica.getContatti()) {
			lista_dto.add(Conversioni.daContattoAContattoDTO(contatto));
		}
		return new RubricaDTO(rubrica.getId(), rubrica.getProprietario(), lista_dto, rubrica.getAnnoCreazione());
	}
	
	public static Rubrica daRubricaDTOARubrica(RubricaDTO dto) {
		List<Contatto> lista_entity = new ArrayList<Contatto>();
		for (ContattoDTO contatto_dto: dto.getContatti()) {
			lista_entity.add(Conversioni.daContattoDTOAContatto(contatto_dto));
		}
		
		return new Rubrica(dto.getId(), dto.getProprietario(), lista_entity, dto.getAnnoCreazione());
	}

}
