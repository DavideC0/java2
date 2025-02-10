package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Studente;

public class DAOStudente {
	
private Map<String, Studente> mappa = new HashMap<String, Studente>();
	
	public Studente registra(Studente studente) {
		if (mappa.containsKey(studente.getMatricola())) {
			throw new RuntimeException("Studente già presente " + studente.getMatricola());
		}
		mappa.put(studente.getMatricola(), studente);
		return studente;
	}
	
	public Studente selectById(String id) {
		return mappa.get(id);
	}
	
	public List<Studente> selectAll() {
		return new ArrayList<Studente>(mappa.values());
	}
	
	public boolean cancella(String id) {
		Studente studente = mappa.remove(id);
		if (studente!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Studente modifica(String id, String indirizzo) {
		if (!mappa.containsKey(id)) {
			return null;
		}
		mappa.get(id).setIndirizzo(indirizzo);
		return mappa.get(id);
	}

}
