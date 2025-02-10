package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Professore;

public class DAOProfessore {
	
	private Map<Integer, Professore> mappa = new HashMap<Integer, Professore>();
	
	public Professore registra(Professore professore) {
		if (mappa.containsKey(professore.getId())) {
			throw new RuntimeException("Professore già presente " + professore.getId());
		}
		mappa.put(professore.getId(), professore);
		return professore;
	}
	
	public Professore selectById(int id) {
		return mappa.get(id);
	}
	
	public List<Professore> selectAll() {
		return new ArrayList<Professore>(mappa.values());
	}
	
	public boolean cancella(int id) {
		Professore prof = mappa.remove(id);
		if (prof!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Professore modifica(int id, String materia) {
		if (!mappa.containsKey(id)) {
			return null;
		}
		mappa.get(id).setMateria(materia);
		return mappa.get(id);
	}

}
