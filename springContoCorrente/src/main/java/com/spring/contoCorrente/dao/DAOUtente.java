package com.spring.contoCorrente.dao;

import java.util.List;

import com.spring.contoCorrente.entity.Utente;

public interface DAOUtente {
	public void insert(Utente user);
	
	public void update(Utente user);
	
	public void delete(int id);
	
	public Utente selectById(int id);
	
	public List<Utente> selectAll();
}
