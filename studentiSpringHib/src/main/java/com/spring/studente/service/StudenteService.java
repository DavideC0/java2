package com.spring.studente.service;

import java.util.List;

import com.spring.studente.dto.StudenteDTO;

public interface StudenteService {
	
	public boolean immatricola(StudenteDTO studente);
	public StudenteDTO cerca(int matricola);
	public List<StudenteDTO> cercaTutti();
	public StudenteDTO cancella(int matricola);
	public List<StudenteDTO> getGiovani(int anno);

}
