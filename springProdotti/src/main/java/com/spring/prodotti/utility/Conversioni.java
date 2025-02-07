package com.spring.prodotti.utility;

import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.dto.ProdottoNoIdDTO;
import com.spring.prodotti.entity.Prodotto;

public class Conversioni {
	public static Prodotto daProdottoDTOAProdotto(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getQuantita(), dto.getMarca(), dto.getModello(), dto.getDescrizione(), dto.getCategoria(), dto.getPrezzo_cons(), dto.getPrezzo_max());
	}

	public static ProdottoDTO daProdottoProdottoDTO(Prodotto entity) {
		return new ProdottoDTO(entity.getId(), entity.getQuantita(), entity.getMarca(), entity.getModello(), entity.getDescrizione(), entity.getCategoria(), entity.getPrezzo_cons(), entity.getPrezzo_max());
	}
	
	public static ProdottoNoIdDTO daProdottoaProdottonoIdDTO(Prodotto entity) {
		return new ProdottoNoIdDTO(entity.getQuantita(), entity.getMarca(), entity.getModello(), entity.getDescrizione(), entity.getCategoria(), entity.getPrezzo_cons(), entity.getPrezzo_max());
	}
}

