package com.spring.universita.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.universita.dao.DAOProfessore;
import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.utility.Conversioni;

public class ProfessoreService {
	
	private DAOProfessore dao = new DAOProfessore();
	
	public ProfessoreDTO registra(ProfessoreDTO professore) {
		Professore entity = Conversioni.daProfDTOAProf(professore);
		dao.registra(entity);
		return Conversioni.daProfAProfDTO(entity);
	}
	
	public ProfessoreDTO visualizzaId(int id) {
		Professore entity = dao.selectById(id);
		return Conversioni.daProfAProfDTO(entity);
	}
	
	public List<ProfessoreDTO> mostraTutti() {
		List<Professore> lista = dao.selectAll();
		List<ProfessoreDTO> dto = new ArrayList<ProfessoreDTO>();
		for (Professore prof: lista) {
			dto.add(Conversioni.daProfAProfDTO(prof));
		}
		return dto;
	}
	
	public boolean cancella(int id) {
		return dao.cancella(id);
	}
	
	public ProfessoreDTO modifica(int id, String materia) {
		return Conversioni.daProfAProfDTO(dao.modifica(id, materia));
	}

}
