package com.spring.contoCorrente.entity;

import java.util.ArrayList;
import java.util.List;

public class Conto {
	
	private int cc, saldo;
	private List<Integer> movimenti;
	private int user;
	public Conto(int cc, int saldo, List<Integer> movimenti, int user) {
		super();
		this.cc = cc;
		this.saldo = saldo;
		this.movimenti = movimenti;
		this.user = user;
	}
	public Conto(int cc, int user) {
		super();
		this.cc = cc;
		this.saldo=0;
		this.movimenti = new ArrayList<Integer>();
		this.user = user;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public Conto() {
		super();
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public List<Integer> getMovimenti() {
		return movimenti;
	}
	public void setMovimenti(List<Integer> movimenti) {
		this.movimenti = movimenti;
	}
	
	

}
