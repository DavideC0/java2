package com.spring.impiegati.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.impiegati.dao.DAOImpiegati;
import com.spring.impiegati.dto.ImpiegatoDTO;
import com.spring.impiegati.entity.Impiegato;

@Service
@Transactional
public class impiegatiServiceImpl implements ImpiegatiService {

	@Autowired
	private DAOImpiegati dao;
	
	@Override
	public boolean assumi(ImpiegatoDTO impiegato) {
		Impiegato entity = new Impiegato(impiegato.getMatricola(), impiegato.getNome(), impiegato.getCognome(), impiegato.getSalario());
		dao.save(entity);
		return true;
	}

	@Override
	public ImpiegatoDTO cerca(int matricola) {
		Optional<Impiegato> e = dao.findById(matricola);
		return new ImpiegatoDTO(e.get().getMatricola(), e.get().getNome(), e.get().getCognome(), e.get().getSalario());
	}

	@Override
	public List<ImpiegatoDTO> cercaTutti() {
		List<Impiegato> e = new ArrayList<Impiegato>(dao.findAll());
		List<ImpiegatoDTO> dto = new ArrayList<ImpiegatoDTO>();
		for (Impiegato s: e) {
			dto.add(new ImpiegatoDTO(s.getMatricola(), s.getNome(), s.getCognome(), s.getSalario()));
		}
		return dto;
	}

	@Override
	public ImpiegatoDTO cancella(int matricola) {
		Optional<Impiegato> e = dao.findById(matricola);
		dao.deleteById(matricola);
		return new ImpiegatoDTO(e.get().getMatricola(), e.get().getNome(), e.get().getCognome(), e.get().getSalario());
	}

	@Override
	public ImpiegatoDTO updateSalario(int matricola, double salarioNuovo) {
		Optional<Impiegato> e = dao.findById(matricola);
		e.get().setSalario(salarioNuovo);
		return new ImpiegatoDTO(e.get().getMatricola(), e.get().getNome(), e.get().getCognome(), e.get().getSalario());
	}

	@Override
	public String cancellaRNC(int matricola) {
		Optional<Impiegato> e = dao.findById(matricola);
		dao.deleteById(matricola);
		return e.get().getNome() + " " + e.get().getCognome();
	}

	@Override
	public List<String> cercaNominativi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpiegatoDTO> getSalarioMaggiore(double valore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpiegatoDTO> getOrdinatiByCognome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpiegatoDTO> getOrdinatiBySalario() {
		// TODO Auto-generated method stub
		return null;
	}

}
