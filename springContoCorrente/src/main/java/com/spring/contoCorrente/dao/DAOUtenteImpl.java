package com.spring.contoCorrente.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.contoCorrente.entity.Utente;

@Repository
public class DAOUtenteImpl implements DAOUtente {
	
	private Map<Integer, Utente> mappa = new HashMap<Integer, Utente>();

	@Override
	public void insert(Utente user) {
		if (mappa.containsKey(user.getId())) {
			throw new RuntimeException("Utente già presente " + user.getId());
		}
		mappa.put(user.getId(), user);
		
	}

	@Override
	public Utente selectById(int id) {
		return mappa.get(id);
	}

	@Override
	public List<Utente> selectAll() {
		return new ArrayList<Utente>(mappa.values());
	}

	@Override
	public void update(Utente user) {
		if (!mappa.containsKey(user.getId())) {
			throw new RuntimeException("Utente inesistente");
		}
		mappa.put(user.getId(), user);
		
	}

	@Override
	public void delete(int id) {
		mappa.remove(id);
		
	}

}
