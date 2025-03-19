package com.spring.contoCorrente.service;

import java.util.List;

import com.spring.contoCorrente.dto.ContoDTO;

public interface ContoService {
	
	public void insert(ContoDTO dto);
	
	public void prelievo(int cc, int quantita);
	
	public void versamento(int cc, int quantita);
	
	public int getSaldo(int cc);
	
	public List<Integer> getMovimenti(int cc);
}
