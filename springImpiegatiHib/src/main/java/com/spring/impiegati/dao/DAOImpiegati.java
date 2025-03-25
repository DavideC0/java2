package com.spring.impiegati.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.impiegati.entity.Impiegato;

public interface DAOImpiegati extends JpaRepository<Impiegato, Integer>{

	@Query(nativeQuery = true, value="select * from impiegato where salario > :valore")
	public List<Impiegato> getSalarioMaggiore(double valore);
	
	@Query(nativeQuery = true, value="select * from impiegato order by cognome")
	public List<Impiegato> getOrdinatiByCognome();
	
	@Query(nativeQuery = true, value="select * from impiegato order by salario")
	public List<Impiegato> getOrdinatiBySalario();
}
