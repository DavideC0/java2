package com.spring.utente.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.utente.dao.DAOUtente;
import com.spring.utente.dto.NomeCognomeDTO;
import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;

public class UtenteService {

	private DAOUtente dao = new DAOUtente(); //questo costruttore crea la mappa vuota di utenti
	
	public void registra(UtenteDTO dto) {
		//trasformo da DTO ad entity
        Utente entity = Conversioni.daUtenteDTOAUtente(dto);

        //chiamo il dao per inserire
        dao.insert(entity);
	}
	
	public UtenteDTO cercaPerId(int id) {
		//chiamo il dao
		Utente utente = dao.selectById(id);
		
		//trasformo da entity a DTO
		return Conversioni.daUtenteAUtenteDTO(utente);
	}
	
	public List<UtenteDTO> mostraTutti(){
		//chiamo il dao
		List<Utente> lista = dao.selectAll();
		
		//converto
		List<UtenteDTO> listaDto = new ArrayList<UtenteDTO>();
		for (Utente utente: lista) {
			UtenteDTO utenteDto = Conversioni.daUtenteAUtenteDTO(utente);
			listaDto.add(utenteDto);
		}
		return listaDto;
	}
	
	public boolean cancella(int id) {
		return dao.delete(id);
	}
	
	public UtenteDTO modificaPassword(int id, String password) {
		Utente entity = dao.updatePassword(id, password); 
		if(entity != null) {
			return Conversioni.daUtenteAUtenteDTO(entity);
		}
		return null;
	}
	
	public void modificaUtente(UtenteDTO utenteDto) {
		Utente utente = Conversioni.daUtenteDTOAUtente(utenteDto);
		dao.update(utente);
	}
	
	public List<String> mostraNomi(){
		List<Utente> lista = dao.selectAll();
		List<String> listaNomi = new ArrayList<String>();
		for (Utente utente: lista) {
			String nome = utente.getNome();
			listaNomi.add(nome);
		}
		return listaNomi;
	}
	
	public List<String> mostraNomiECognomi(){
		List<Utente> lista = dao.selectAll();
		List<String> listaNomi = new ArrayList<String>();
		for (Utente utente: lista) {
			String nome = utente.getNome();
			String cognome = utente.getCognome();
			String nomecognome = nome + cognome;
			listaNomi.add(nomecognome);
		}
		return listaNomi;
	}
	
	public List<NomeCognomeDTO> getNomiCognomi() {
		List<Utente> lista = dao.selectAll();
		List<NomeCognomeDTO> listaDto = new ArrayList<NomeCognomeDTO>();
		for (Utente utente: lista) {
			NomeCognomeDTO dto = new NomeCognomeDTO(utente.getNome(), utente.getCognome());
			listaDto.add(dto);
		}
		return listaDto;
	}
	
}
