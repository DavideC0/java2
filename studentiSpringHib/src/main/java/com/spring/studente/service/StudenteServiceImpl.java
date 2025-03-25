package com.spring.studente.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.studente.dao.DAOStudente;
import com.spring.studente.dto.StudenteDTO;
import com.spring.studente.entity.Studente;

@Service
@Transactional
public class StudenteServiceImpl implements StudenteService {
	
	@Autowired
	private DAOStudente dao;

	@Override
	public boolean immatricola(StudenteDTO studente) {
		Studente entity = new Studente(studente.getMatricola(), studente.getNome(), studente.getCognome(), studente.getAnnoImm());
		dao.save(entity);
		return true;
	}

	@Override
	public StudenteDTO cerca(int matricola) {
		Optional<Studente> entity = dao.findById(matricola);
		return new StudenteDTO(entity.get().getMatricola(), entity.get().getNome(), entity.get().getCognome(), entity.get().getAnnoImm());
	}

	@Override
	public List<StudenteDTO> cercaTutti() {
		List<Studente> e = new ArrayList<Studente>(dao.findAll());
		List<StudenteDTO> dto = new ArrayList<StudenteDTO>();
		for (Studente s: e) {
			dto.add(new StudenteDTO(s.getMatricola(), s.getNome(), s.getCognome(), s.getAnnoImm()));
		}
		return dto;
	}

	@Override
	public StudenteDTO cancella(int matricola) {
		Optional<Studente> entity = dao.findById(matricola);
		dao.deleteById(matricola);
		return new StudenteDTO(entity.get().getMatricola(), entity.get().getNome(), entity.get().getCognome(), entity.get().getAnnoImm());
	}

	@Override
	public List<StudenteDTO> getGiovani(int anno) {
		List<Studente> e = dao.getStudentiGiovani(anno);
		List<StudenteDTO> dto = new ArrayList<StudenteDTO>();
		for (Studente s: e) {
			dto.add(new StudenteDTO(s.getMatricola(), s.getNome(), s.getCognome(), s.getAnnoImm()));
		}
		return dto;
	}

}
