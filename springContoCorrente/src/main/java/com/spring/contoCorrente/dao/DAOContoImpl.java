package com.spring.contoCorrente.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.contoCorrente.entity.Conto;
@Repository
public class DAOContoImpl implements DAOConto {

	private Map<Integer, Conto> mappa = new HashMap<Integer, Conto>();
	
	@Override
	public void insert(Conto conto) {
		if (mappa.containsKey(conto.getCc())) {
			throw new RuntimeException("Conto già presente " + conto.getCc());
		}
		mappa.put(conto.getCc(), conto);
		
	}

	@Override
	public Conto selectById(int id) {
		return mappa.get(id);
	}

	@Override
	public List<Conto> selectAll() {
		return new ArrayList<Conto>(mappa.values());
	}

	@Override
	public void update(Conto conto) {
		if (!mappa.containsKey(conto.getCc())) {
			throw new RuntimeException("Conto inesistente");
		}
		mappa.put(conto.getCc(), conto);
		
	}

}
