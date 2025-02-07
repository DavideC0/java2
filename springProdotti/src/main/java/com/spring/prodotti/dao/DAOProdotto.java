package com.spring.prodotti.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.prodotti.dto.ReportDTO;
import com.spring.prodotti.entity.Prodotto;

public class DAOProdotto {
	private Map<Integer, Prodotto> mappa = new HashMap<Integer, Prodotto>();
	
	public Prodotto register (Prodotto prodotto) {
		if (mappa.containsKey(prodotto.getId())) {
			throw new RuntimeException("Prodotto già presente " + prodotto.getId());
		}
		mappa.put(prodotto.getId(), prodotto);
		return prodotto;
	}
	
	public List<Prodotto> selectAll() {
		return new ArrayList<Prodotto>(mappa.values());
	}
	
	public Prodotto selectById(int id) {
		return mappa.get(id);
	}
	
	public ReportDTO report() {
		List<String> lista_descrizioni = new ArrayList<String>();
		List<String> lista_non_dispo = new ArrayList<String>();
		double media_prezzi = 0;
		int non_disp = 0;
		int tot = 0;
		for (int key: mappa.keySet()) {
			lista_descrizioni.add(mappa.get(key).getDescrizione());
			tot += mappa.get(key).getQuantita();
			if (mappa.get(key).getQuantita() == 0) {
				non_disp++;
				lista_non_dispo.add(mappa.get(key).getModello());
			}
			media_prezzi += mappa.get(key).getPrezzo_cons();
		}
		media_prezzi /= mappa.size();
		return new ReportDTO(lista_descrizioni, lista_non_dispo, tot, non_disp, media_prezzi);
	}
}
