package com.spring.contoCorrente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.contoCorrente.dao.DAOConto;
import com.spring.contoCorrente.dto.ContoDTO;
import com.spring.contoCorrente.entity.Conto;
import com.spring.contoCorrente.utility.Conversioni;

@Service
public class ContoServiveImpl implements ContoService{

	@Autowired
	private DAOConto dao;
	
	public void insert(ContoDTO dto) {
		Conto entity = Conversioni.daContoDTOAConto(dto);
		dao.insert(entity);
	}

	@Override
	public void prelievo(int cc, int quantita) {
		Conto entity = dao.selectById(cc);
		entity.setSaldo(entity.getSaldo()-quantita);
		entity.getMovimenti().add(-quantita);
		System.out.println(entity);
		dao.update(entity);
		
	}

	@Override
	public void versamento(int cc, int quantita) {
		Conto entity = dao.selectById(cc);
		entity.setSaldo(entity.getSaldo()+quantita);
		entity.getMovimenti().add(+quantita);
		dao.update(entity);
	}

	@Override
	public int getSaldo(int cc) {
		return dao.selectById(cc).getSaldo();
	}

	@Override
	public List<Integer> getMovimenti(int cc) {
		return dao.selectById(cc).getMovimenti();
	}
}
