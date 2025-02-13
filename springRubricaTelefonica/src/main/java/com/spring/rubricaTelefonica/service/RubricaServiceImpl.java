package com.spring.rubricaTelefonica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rubricaTelefonica.dao.DAORubrica;
import com.spring.rubricaTelefonica.dto.ContattoDTO;
import com.spring.rubricaTelefonica.dto.RubricaDTO;
import com.spring.rubricaTelefonica.entity.Contatto;
import com.spring.rubricaTelefonica.entity.Rubrica;
import com.spring.rubricaTelefonica.utility.Conversioni;

@Service
public class RubricaServiceImpl implements RubricaService {
	
	@Autowired
	private DAORubrica dao;
	
	public void inserisciRubrica(RubricaDTO dto) {
		Rubrica entity = Conversioni.daRubricaDTOARubrica(dto);
		dao.insert(entity);
	}
	
	public RubricaDTO visualizzaById(int id) {
		Rubrica entity = dao.selectById(id);
		return Conversioni.daRubricaARubricaDTO(entity);
	}
	
	public List<RubricaDTO> mostraTutti() {
		List<Rubrica> lista = dao.selectAll();
		List<RubricaDTO> dto = new ArrayList<RubricaDTO>();
		for (Rubrica rubrica: lista) {
			dto.add(Conversioni.daRubricaARubricaDTO(rubrica));
		}
		return dto;
	}

	public boolean cancellaRubrica(int id) {
		return dao.cancellaRubrica(id);
	}
	
	public String visualizzaIdNoList(int id) {
		RubricaDTO dto = visualizzaById(id);
		return "Proprietario: " + dto.getProprietario() + " Anno di creazione: " + dto.getAnnoCreazione();
	}
	
	public RubricaDTO modificaProprietario(int id, String nome) {
		return Conversioni.daRubricaARubricaDTO(dao.modificaProprietario(id, nome));
	}
	
	public RubricaDTO modificaAnno(int id, int anno) {
		return Conversioni.daRubricaARubricaDTO(dao.modificaAnno(id, anno));
	}
	
	public String mostraNumeroRubriche() {
		List<RubricaDTO> dto = mostraTutti();
		List<String> nomi = new ArrayList<String>();
		for (RubricaDTO rubrica: dto) {
			nomi.add(rubrica.getProprietario());
		}
		return "Proprietari: " + nomi + " Numero totale: " + nomi.size();
	}
	
	public String visualizzavecchio() {
		List<RubricaDTO> dto = mostraTutti();
		RubricaDTO vecchio = dto.get(0);
		for (RubricaDTO rubrica: dto) {
			if (rubrica.getAnnoCreazione()<vecchio.getAnnoCreazione()) {
				vecchio = rubrica;
			}
		}
		return "Proprietario: " + vecchio.getProprietario() + " Anno creazione: " + vecchio.getAnnoCreazione();
	}
	public List<Integer> mostraAnniCrescente() {
		List<RubricaDTO> dto = mostraTutti();
		List<Integer> anni = new ArrayList<Integer>();
		for (RubricaDTO rubrica: dto) {
			anni.add(rubrica.getAnnoCreazione());
		}
		anni.sort(null);
		return anni;
	}
	
	
	public String visualizzaNumeroContatti(int id) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(id));
		return "Proprietario: " + dto.getProprietario() + " Numero Contatti: " + dto.getContatti().size();
	}
	
	public ContattoDTO inserisciContatto(int id, ContattoDTO contatto) {
		Contatto entity = Conversioni.daContattoDTOAContatto(contatto);
		return Conversioni.daContattoAContattoDTO(dao.insertContatto(id,entity));
	}
	
	public ContattoDTO mostraContattoById(int idRubrica, int idContatto) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(idRubrica));
		for (ContattoDTO contatto: dto.getContatti()) {
			if (contatto.getId() == idContatto) {
				return contatto;
			}
		}
		return null;
	}
	
	public ContattoDTO modificaContatto(int id, ContattoDTO contatto) {
		if (dao.check(id, contatto.getId())) {
			dao.cancellaContatto(id, contatto.getId());
			dao.insertContatto(id, Conversioni.daContattoDTOAContatto(contatto));
			return contatto;
		} else {
			return null;
		}
	}
	
	public boolean cancellaContatto(int idRubrica, int idContatto) {
		if (dao.check(idRubrica, idContatto)) {
			return dao.cancellaContatto(idRubrica, idContatto);
		} else {
			return false;
		}
	}
	
	public List<ContattoDTO> visualizzaContattiRUbrica(int id) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(id));
		return dto.getContatti();
	}
	
	public int contaContatti(int id) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(id));
		return dto.getContatti().size();
	}
	
	public List<ContattoDTO> mostraContattoByNumero(int idRubrica, String numero) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(idRubrica));
		if (dto != null) {
			List<ContattoDTO> lista = new ArrayList<ContattoDTO>();
			for (ContattoDTO cont: dto.getContatti()) {
				if(cont.getNumero().equals(numero)) {
					lista.add(cont);
				}
			}
			return lista;
		} else {
			return null;
		}
	}
	
	public List<String> mostraNomeByGruppo(int idRubrica, String gruppo) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(idRubrica));
		if (dto != null) {
			List<String> lista = new ArrayList<String>();
			for (ContattoDTO cont: dto.getContatti()) {
				if(cont.getGruppo().equals(gruppo)) {
					lista.add(cont.getNome() + " " + cont.getCognome());
				}
			}
			return lista;
		} else {
			return null;
		}
	}
	
	public int mostraNumeroByGruppo(int idRubrica, String gruppo) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(idRubrica));
		if (dto != null) {
			int tot = 0;
			for (ContattoDTO cont: dto.getContatti()) {
				if(cont.getGruppo().equals(gruppo)) {
					tot++;
				}
			}
			return tot;
		} else {
			return 0;
		}
	}
	
	public void cancellabyGruppo(int idRubrica, String gruppo) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(idRubrica));
		if (dto != null) {
			for (ContattoDTO cont: dto.getContatti()) {
				if(cont.getGruppo().equals(gruppo)) {
					dao.cancellaContatto(idRubrica, cont.getId());
				}
			}
		}
	}
	
	public boolean assegnaPreferito(int idRubrica, int idContatto) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(idRubrica));
		if (dto != null) {
			for (ContattoDTO cont: dto.getContatti()) {
				if(cont.getId() == idContatto) {
					dao.updatePreferito(idRubrica, idContatto);
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
	
	public List<ContattoDTO> visualizzaPreferiti(int id) {
		RubricaDTO dto = Conversioni.daRubricaARubricaDTO(dao.selectById(id));
		List<ContattoDTO> lista = new ArrayList<ContattoDTO>();
		for (ContattoDTO cont: dto.getContatti()) {
			if (cont.isPreferito()) {
				lista.add(cont);
			}
		}
		return lista;
	}
}
