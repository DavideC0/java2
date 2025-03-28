package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.dto.VenditoreDTONoPass;
import com.spring.ecommerce.dto.VenditoreDTONoPassProd;

public interface VenditoreService {
	
	public boolean creaVenditoreVuoto(VenditoreDTO dto);
	public VenditoreDTONoPass cercaTutto(Integer idVenditore);
	public VenditoreDTONoPassProd cerca(Integer idvenditore);
	public VenditoreDTO modificaPassword(Integer idVenditore, String nuovaPassword);
	public boolean aggiungiProdotto(Integer idVenditore, ProdottoDTO prodotto);
	public boolean modificaQuantita(Integer idVenditore, Integer idProdotto, Integer quantitaNuova);
}
