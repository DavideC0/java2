package com.spring.rubricaTelefonica.dao;

import java.util.List;

import com.spring.rubricaTelefonica.entity.Contatto;
import com.spring.rubricaTelefonica.entity.Rubrica;

public interface DAORubrica {
	public void insert(Rubrica rubrica);

	public Rubrica selectById(int id);

	public List<Rubrica> selectAll();

	public boolean cancellaRubrica(int id);

	public Rubrica modificaProprietario(int id, String nome);

	public Rubrica modificaAnno(int id, int anno);

	public Contatto insertContatto(int id, Contatto entity);

	public boolean check(int id, int id2);

	public boolean cancellaContatto(int id, int id2);

	public void updatePreferito(int idRubrica, int idContatto);
}
