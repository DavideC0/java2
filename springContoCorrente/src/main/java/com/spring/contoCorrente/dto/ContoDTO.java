package com.spring.contoCorrente.dto;

import java.util.ArrayList;
import java.util.List;

public class ContoDTO {
	
	private int cc, saldo;
	private List<Integer> movimenti =  new ArrayList<Integer>();
	private int userDto;
	public ContoDTO(int cc, int saldo, List<Integer> movimenti, int userDto) {
		super();
		this.cc = cc;
		this.saldo = saldo;
		this.movimenti = movimenti;
		this.userDto = userDto;
	}
	public ContoDTO(int cc, int userDto) {
		super();
		this.cc = cc;
		this.saldo=0;
		this.userDto = userDto;
	}
	public ContoDTO() {
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
	public int getUserDto() {
		return userDto;
	}
	public void setUserDto(int userDto) {
		this.userDto = userDto;
	}
	

}
