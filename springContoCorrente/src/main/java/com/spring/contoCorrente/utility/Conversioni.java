package com.spring.contoCorrente.utility;

import com.spring.contoCorrente.dto.ContoDTO;
import com.spring.contoCorrente.dto.UtenteDTO;
import com.spring.contoCorrente.entity.Conto;
import com.spring.contoCorrente.entity.Utente;

public class Conversioni {
	
	public static Utente daUtenteDTOAUtente(UtenteDTO dto) {
		return new Utente(dto.getId(), dto.getNome(), dto.getCognome(), dto.getTelefono());
	};
	
	public static UtenteDTO daUtenteAUtenteDTO(Utente entity) {
		return new UtenteDTO(entity.getId(), entity.getNome(), entity.getCognome(), entity.getTelefono());
	};
	
	public static Conto daContoDTOAConto(ContoDTO dto) {
		return new Conto(dto.getCc(), dto.getSaldo(), dto.getMovimenti(), dto.getUserDto());
	}
	
	public static ContoDTO daContoAContoDTO(Conto entity) {
		return new ContoDTO(entity.getCc(), entity.getSaldo(), entity.getMovimenti(), entity.getUser());
	}

}
