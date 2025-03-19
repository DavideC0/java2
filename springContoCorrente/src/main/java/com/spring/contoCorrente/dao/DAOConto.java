package com.spring.contoCorrente.dao;

import java.util.List;

import com.spring.contoCorrente.entity.Conto;

public interface DAOConto {
	
	public void insert(Conto conto);
	
	public Conto selectById(int id);
	
	public List<Conto> selectAll();
	
	public void update(Conto conto);

}
