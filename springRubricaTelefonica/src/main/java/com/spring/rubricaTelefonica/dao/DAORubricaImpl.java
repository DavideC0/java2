package com.spring.rubricaTelefonica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.rubricaTelefonica.entity.Contatto;
import com.spring.rubricaTelefonica.entity.Rubrica;

@Repository
public class DAORubricaImpl implements DAORubrica {
	
	private Map<Integer, Rubrica> mappa = new HashMap<Integer, Rubrica>();
	
	public void insert(Rubrica rubrica) {
		if (mappa.containsKey(rubrica.getId())) {
			throw new RuntimeException("Rubrica già presente " + rubrica.getId());
		}
		mappa.put(rubrica.getId(), rubrica);
	}
	public Rubrica selectById(int id) {
		return mappa.get(id);
	}
	
	public List<Rubrica> selectAll() {
		return new ArrayList<Rubrica>(mappa.values());
	}

	public boolean cancellaRubrica(int id) {
		Rubrica rubrica = mappa.remove(id);
		if (rubrica!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Rubrica modificaProprietario(int id, String nome) {
		if (!mappa.containsKey(id)) {
			return null;
		}
		mappa.get(id).setProprietario(nome);
		return mappa.get(id);
	}
	
	public Rubrica modificaAnno(int id, int anno) {
		if (!mappa.containsKey(id)) {
			return null;
		}
		mappa.get(id).setAnnoCreazione(anno);
		return mappa.get(id);
	}
	
	public Contatto insertContatto(int id, Contatto entity) {
		if (!mappa.containsKey(id)) {
			return null;
		}
		for (Contatto contatto: mappa.get(id).getContatti()) {
			if (contatto.getId() == entity.getId()) {
				return null;
			}
		}
		mappa.get(id).addContatto(entity);
		return entity;
	}
	
	public boolean cancellaContatto(int id, int idContatto) {
		if (!mappa.containsKey(id)) {
			return false;
		} else {
			for (Contatto contatto: mappa.get(id).getContatti()) {
				if (contatto.getId() == idContatto) {
					Contatto cont = mappa.get(id).getContatti().remove(idContatto);
					if (cont != null) {
						return true;
					} else {
						return false;
					}
				}
			}
			return false;
		}
	}
	
	public boolean check(int id, int idContatto) {
		if (!mappa.containsKey(id)) {
			return false;
		} else {
			for (Contatto contatto: mappa.get(id).getContatti()) {
				if (contatto.getId() == idContatto) {
					return true;
				}
			}
			return false;
		}
	}
	
	public void updatePreferito(int idRubrica, int idContatto) {
		for (Contatto cont: mappa.get(idRubrica).getContatti()) {
			if (cont.getId() == idContatto) {
				mappa.get(cont.getId()).getContatti().get(idContatto).setPreferito(true);
			}
		}
	}
}
