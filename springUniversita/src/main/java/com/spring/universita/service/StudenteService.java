package com.spring.universita.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.universita.dao.DAOStudente;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Studente;
import com.spring.universita.utility.Conversioni;

public class StudenteService {

private DAOStudente dao = new DAOStudente();
	
	public StudenteDTO registra(StudenteDTO studente) {
		Studente entity = Conversioni.daStudenteDTOAStudente(studente);
		dao.registra(entity);
		return Conversioni.daStudenteAStudenteDTO(entity);
	}
	
	public StudenteDTO visualizzaId(String id) {
		Studente entity = dao.selectById(id);
		return Conversioni.daStudenteAStudenteDTO(entity);
	}
	
	public List<StudenteDTO> mostraTutti() {
		List<Studente> lista = dao.selectAll();
		List<StudenteDTO> dto = new ArrayList<StudenteDTO>();
		for (Studente stud: lista) {
			dto.add(Conversioni.daStudenteAStudenteDTO(stud));
		}
		return dto;
	}
	
	public boolean cancella(String id) {
		return dao.cancella(id);
	}
	
	public StudenteDTO modifica(String id, String indirizzo) {
		return Conversioni.daStudenteAStudenteDTO(dao.modifica(id, indirizzo));
	}
	
	public List<String> mostraNomi() {
		List<Studente> lista = dao.selectAll();
		List<String> nomi = new ArrayList<String>();
		for (Studente stud: lista) {
			nomi.add(stud.getNome());
		}
		return nomi;
	}
	
	public StudenteDTO mostraGiovane() {
		List<Studente> lista = dao.selectAll();
		Studente giovane = lista.get(0);
		for (Studente stud: lista) {
			if (stud.getAnnoNascita()>giovane.getAnnoNascita()) {
				giovane = stud;
			}
		}
		return Conversioni.daStudenteAStudenteDTO(giovane);
	}
	
	public StudenteDTO mostraIscritto() {
		List<Studente> lista = dao.selectAll();
		Studente vecchio = lista.get(0);
		for (Studente stud: lista) {
			if (stud.getAnnoImmatricolazione()<vecchio.getAnnoImmatricolazione()) {
				vecchio = stud;
			}
		}
		return Conversioni.daStudenteAStudenteDTO(vecchio);
	}
}
