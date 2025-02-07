package com.spring.utente.dto;

public class UtenteDTO {

		private int id;
		private String nome, cognome, username, password;
		private int annoNascita;
		
		public UtenteDTO(int id, String nome, String cognome, String username, String password, int annoNascita) {
			super();
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.username = username;
			this.password = password;
			this.annoNascita = annoNascita;
		}
		
		public UtenteDTO() {
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getAnnoNascita() {
			return annoNascita;
		}

		public void setAnnoNascita(int annoNascita) {
			this.annoNascita = annoNascita;
		}

}