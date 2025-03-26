package com.spring.rubrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rubrica.dao.DAORubrica;
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.utility.Conversioni;

@Service
@Transactional
public class RubricaServiceImpl implements RubricaService {
	
	@Autowired
	private DAORubrica dao;
	
	@Override
	public boolean creaRubricaVuota(RubricaDTO dto) {
		Rubrica entity = Conversioni.daRubricaDTOARubrica(dto);
		dao.save(entity);
		return true;
	}

	@Override
	public RubricaDTO cerca(Integer idRubrica) {
		RubricaDTO = Conversioni.
	}

	@Override
	public boolean aggiungiContatto(Integer idRubrica, ContattoDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
