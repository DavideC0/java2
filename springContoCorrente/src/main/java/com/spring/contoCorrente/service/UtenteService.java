package com.spring.contoCorrente.service;

import java.util.List;

import com.spring.contoCorrente.dto.UtenteDTO;

public interface UtenteService {
	
	public void insert(UtenteDTO user);
	
	public void update(UtenteDTO user);
	
	public void delete(int id);
	
	public UtenteDTO selectById(int id);
	
	public List<UtenteDTO> selectAll();

}
