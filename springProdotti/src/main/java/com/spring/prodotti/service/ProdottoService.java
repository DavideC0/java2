package com.spring.prodotti.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.prodotti.dao.DAOProdotto;
import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.dto.ReportDTO;
import com.spring.prodotti.entity.Prodotto;
import com.spring.prodotti.utility.Conversioni;

public class ProdottoService {
	
	private DAOProdotto dao = new DAOProdotto();
	
	public ProdottoDTO registra(ProdottoDTO prodotto) {
		Prodotto entity = Conversioni.daProdottoDTOAProdotto(prodotto);
		dao.register(entity);
		return Conversioni.daProdottoProdottoDTO(entity);
	}
	
	public List<ProdottoDTO> mostraTutti() {
		List<Prodotto> lista = dao.selectAll();
		List<ProdottoDTO> dto = new ArrayList<ProdottoDTO>();
		for (Prodotto prod: lista) {
			dto.add(Conversioni.daProdottoProdottoDTO(prod));
		}
		return dto;
	}
	
	public ProdottoDTO visualizzaId(int id) {
		Prodotto entity = dao.selectById(id);
		return Conversioni.daProdottoProdottoDTO(entity);
	}
	
	public ReportDTO visualizzaReport() {
		return dao.report();
	}
	
}
