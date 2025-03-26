package com.spring.rubrica.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

public class Conversioni {
	
	public static Contatto daContattoDTOAContatto(ContattoDTO dto) {
		return new Contatto(dto.getIdContatto(), dto.getNome(), dto.getCognome(), dto.getNumero());
	}
	
	public static ContattoDTO daContattoAContattoDTO(Contatto entity) {
		return new ContattoDTO(entity.getIdContatto(), entity.getNome(), entity.getCognome(), entity.getNumero());
	}
	
	public static Rubrica daRubricaDTOARubrica(RubricaDTO dto) {
		Rubrica rubrica = new Rubrica(dto.getIdRubrica(), dto.getProprietario(), dto.getAnno());
		
		List<ContattoDTO> listaD = dto.getContatti();
		
		List<Contatto> lista = listaD.stream()
			.map(contattoD -> Conversioni.daContattoDTOAContatto(contattoD))
			.collect(Collectors.toList());
		rubrica.setContatti(lista);
		return rubrica;
	}
	
	
}
