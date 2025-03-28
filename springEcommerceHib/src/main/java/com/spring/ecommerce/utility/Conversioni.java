package com.spring.ecommerce.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.entity.Prodotto;
import com.spring.ecommerce.entity.Venditore;

public class Conversioni {
	
	public static Prodotto daProdottoDTOAProdotto (ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getDescrizione(), dto.getCategoria(), dto.getPrezzo_unitario(), dto.getSconto(), dto.getQuantita());
	}
	
	public static ProdottoDTO daProdottoAProdottoDTO (Prodotto e) {
		return new ProdottoDTO(e.getId(), e.getDescrizione(), e.getCategoria(), e.getPrezzo_unitario(), e.getSconto(), e.getQuantita());
	}
	
	public static Venditore daVenditoreDTOAVenditore(VenditoreDTO dto) {
		Venditore venditore = new Venditore(dto.getId(), dto.getNome(), dto.getCognome(), dto.getUsername(), dto.getPassword(), dto.getVia(), dto.getVia());
		List<ProdottoDTO> listaD = dto.getProdotti();
		
		List<Prodotto> lista = listaD.stream()
				.map(prodottoD -> Conversioni.daProdottoDTOAProdotto(prodottoD))
				.collect(Collectors.toList());
		venditore.setProdotti(lista);
		
		return venditore;
	}
	
	public static VenditoreDTO daVenditoreAVenditoreDTO(Venditore e) {
		VenditoreDTO venditore = new VenditoreDTO(e.getId(), e.getNome(), e.getCognome(), e.getUsername(), e.getPassword(), e.getVia(), e.getVia());
		List<Prodotto> listaD = e.getProdotti();
		
		List<ProdottoDTO> lista = listaD.stream()
				.map(prodottoD -> Conversioni.daProdottoAProdottoDTO(prodottoD))
				.collect(Collectors.toList());
		venditore.setProdotti(lista);
		
		return venditore;
	}

}
