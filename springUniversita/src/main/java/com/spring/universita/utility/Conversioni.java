package com.spring.universita.utility;

import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.entity.Studente;

public class Conversioni {
	
	public static Professore daProfDTOAProf(ProfessoreDTO dto) {
		return new Professore(dto.getId(), dto.getNome(), dto.getCognome(), dto.getMateria());
	}
	
	public static ProfessoreDTO daProfAProfDTO(Professore entity) {
		return new ProfessoreDTO(entity.getId(), entity.getNome(), entity.getCognome(), entity.getMateria());
	}
	
	public static Studente daStudenteDTOAStudente(StudenteDTO dto) {
		return new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getIndirizzo(), dto.getAnnoNascita(), dto.getAnnoImmatricolazione());
	}

	public static StudenteDTO daStudenteAStudenteDTO(Studente entity) {
		return new StudenteDTO(entity.getMatricola(), entity.getNome(), entity.getCognome(), entity.getIndirizzo(), entity.getAnnoNascita(), entity.getAnnoImmatricolazione());
	}
}
