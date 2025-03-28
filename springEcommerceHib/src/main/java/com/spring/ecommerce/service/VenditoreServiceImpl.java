package com.spring.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.ecommerce.dao.DAOVenditore;
import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;
import com.spring.ecommerce.dto.VenditoreDTONoPass;
import com.spring.ecommerce.dto.VenditoreDTONoPassProd;
import com.spring.ecommerce.entity.Prodotto;
import com.spring.ecommerce.entity.Venditore;
import com.spring.ecommerce.utility.Conversioni;

@Service
@Transactional
public class VenditoreServiceImpl implements VenditoreService {

	@Autowired
	private DAOVenditore dao;
	
	@Override
	public boolean creaVenditoreVuoto(VenditoreDTO dto) {
		List<Venditore> entity = dao.findAll();
		for (Venditore e: entity) {
			if (e.getId() == dto.getId()) {
				return false;
			}
		}
		dao.save(Conversioni.daVenditoreDTOAVenditore(dto));
		return true;
	}

	@Override
	public VenditoreDTONoPass cercaTutto(Integer idVenditore) {
		Optional<Venditore> e = dao.findById(idVenditore);
		VenditoreDTONoPass venditore = new VenditoreDTONoPass(e.get().getId(), e.get().getNome(), e.get().getCognome(), e.get().getUsername(), e.get().getVia(), e.get().getCitta());
		List<Prodotto> lista = e.get().getProdotti();
		List<ProdottoDTO> listaDTO = new ArrayList<ProdottoDTO>();
		for (Prodotto p: lista) {
			listaDTO.add(Conversioni.daProdottoAProdottoDTO(p));
		}
		venditore.setProdotti(listaDTO);
		return venditore;
	}

	@Override
	public VenditoreDTONoPassProd cerca(Integer idvenditore) {
		Optional<Venditore> e = dao.findById(idvenditore);
		return new VenditoreDTONoPassProd(e.get().getId(), e.get().getNome(), e.get().getCognome(), e.get().getUsername(), e.get().getVia(), e.get().getCitta());
	}

	@Override
	public VenditoreDTO modificaPassword(Integer idVenditore, String nuovaPassword) {
		Optional<Venditore> entity = dao.findById(idVenditore);
		entity.get().setPassword(nuovaPassword);
		return Conversioni.daVenditoreAVenditoreDTO(entity.get());
	}

	@Override
	public boolean aggiungiProdotto(Integer idVenditore, ProdottoDTO prodotto) {
		Optional<Venditore> e = dao.findById(idVenditore);
		if (e.get().getProdotti().contains(Conversioni.daProdottoDTOAProdotto(prodotto))) {
			return false;
		} else {
			e.get().getProdotti().add(Conversioni.daProdottoDTOAProdotto(prodotto));
			List<Prodotto> x = e.get().getProdotti();
			e.get().setProdotti(x);
			return true;
		}
	}

	@Override
	public boolean modificaQuantita(Integer idVenditore, Integer idProdotto, Integer quantitaNuova) {
		Optional<Venditore> e = dao.findById(idVenditore);
		e.get().getProdotti().get(idProdotto-1).setQuantita(quantitaNuova);
		return true;
	}

}
