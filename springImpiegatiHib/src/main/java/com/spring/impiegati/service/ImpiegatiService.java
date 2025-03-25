package com.spring.impiegati.service;

import java.util.List;

import com.spring.impiegati.dto.ImpiegatoDTO;

public interface ImpiegatiService {
	
	public boolean assumi(ImpiegatoDTO impiegato);
	public ImpiegatoDTO cerca(int matricola);
	public List<ImpiegatoDTO> cercaTutti();
	public ImpiegatoDTO cancella(int matricola);
	public ImpiegatoDTO updateSalario(int matricola, double salarioNuovo);
	public String cancellaRNC(int matricola);
	public List<String> cercaNominativi();
	public List<ImpiegatoDTO> getSalarioMaggiore(double valore);
	public List<ImpiegatoDTO> getOrdinatiByCognome();
	public List<ImpiegatoDTO> getOrdinatiBySalario();

}
