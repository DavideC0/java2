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
	
	public List<String> mostraCognomi() {
		List<Professore> lista = dao.selectAll();
		List<String> cognomi = new ArrayList<String>();
		for (Professore prof: lista) {
			cognomi.add(prof.getCognome());
		}
		return cognomi;
	}
	
	public List<ProfessoreDTO> mostraMateria(String materia) {
		List<Professore> lista = dao.selectAll();
		List<ProfessoreDTO> dto = new ArrayList<ProfessoreDTO>();
		for (Professore prof: lista) {
			if (prof.getMateria().equals(materia)) {
				dto.add(Conversioni.daProfAProfDTO(prof));
			}
		}
		return dto;
	}
	
	public List<ProfessoreDTO> ordinaCognomi() {
		List<Professore> lista = dao.selectAll();
		lista.sort(null);
		List<ProfessoreDTO> dto = new ArrayList<ProfessoreDTO>();
		for (Professore prof: lista) {
			dto.add(Conversioni.daProfAProfDTO(prof));
		}
		return dto;
	}

}
