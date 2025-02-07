package com.spring.prodotti.dto;

import java.util.List;

public class ReportDTO {
	
	private List<String> elenco_descrizioni, nomi_non_disp;
	private int somma_pezzi, non_disp;
	private double media_prezzi;
	public ReportDTO(List<String> elenco_descrizioni, List<String> nomi_non_disp, int somma_pezzi, int non_disp,
			double media_prezzi) {
		super();
		this.elenco_descrizioni = elenco_descrizioni;
		this.nomi_non_disp = nomi_non_disp;
		this.somma_pezzi = somma_pezzi;
		this.non_disp = non_disp;
		this.media_prezzi = media_prezzi;
	}
	public ReportDTO() {
		super();
	}
	public List<String> getElenco_descrizioni() {
		return elenco_descrizioni;
	}
	public void setElenco_descrizioni(List<String> elenco_descrizioni) {
		this.elenco_descrizioni = elenco_descrizioni;
	}
	public List<String> getNomi_non_disp() {
		return nomi_non_disp;
	}
	public void setNomi_non_disp(List<String> nomi_non_disp) {
		this.nomi_non_disp = nomi_non_disp;
	}
	public int getSomma_pezzi() {
		return somma_pezzi;
	}
	public void setSomma_pezzi(int somma_pezzi) {
		this.somma_pezzi = somma_pezzi;
	}
	public int getNon_disp() {
		return non_disp;
	}
	public void setNon_disp(int non_disp) {
		this.non_disp = non_disp;
	}
	public double getMedia_prezzi() {
		return media_prezzi;
	}
	public void setMedia_prezzi(double media_prezzi) {
		this.media_prezzi = media_prezzi;
	}
	
	

}
