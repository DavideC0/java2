package com.spring.contoCorrente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.contoCorrente.dao.DAOUtente;
import com.spring.contoCorrente.dto.UtenteDTO;
import com.spring.contoCorrente.entity.Utente;
import com.spring.contoCorrente.utility.Conversioni;
@Service
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	private DAOUtente dao;

	@Override
	public void insert(UtenteDTO user) {
		dao.insert(Conversioni.daUtenteDTOAUtente(user));
	}

	@Override
	public void update(UtenteDTO user) {
		dao.update(Conversioni.daUtenteDTOAUtente(user));
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public UtenteDTO selectById(int id) {
		return Conversioni.daUtenteAUtenteDTO(dao.selectById(id));
	}

	@Override
	public List<UtenteDTO> selectAll() {
		List<Utente> entity_list = dao.selectAll();
		List<UtenteDTO> dto = new ArrayList<UtenteDTO>();
		for (Utente u: entity_list) {
			dto.add(Conversioni.daUtenteAUtenteDTO(u));
		}
		return dto;
	}

}
