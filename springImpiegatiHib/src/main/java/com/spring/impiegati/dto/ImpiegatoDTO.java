package com.spring.impiegati.dto;

public class ImpiegatoDTO {
	private int matricola;
	private String nome, cognome;
	private double salario;
	public ImpiegatoDTO() {
		// TODO Auto-generated constructor stub
	}
	public ImpiegatoDTO(int matricola, String nome, String cognome, double salario) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.salario = salario;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	

}
