package com.spring.studente.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.studente.entity.Studente;

public interface DAOStudente extends JpaRepository<Studente, Integer>{
	//eredita in automatico le funzioni CRUD
	
	@Query(nativeQuery = true, value="select * from studente where anno_imm > :anno")
	public List<Studente> getStudentiGiovani(int anno);

}
