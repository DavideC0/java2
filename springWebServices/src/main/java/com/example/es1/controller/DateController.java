package com.example.es1.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/data")
public class DateController {

	@GetMapping(path="/attuale")
	public LocalDateTime getDataAttuale() {
		return LocalDateTime.now();
	}
	
	@GetMapping(path="/scelta")
	public LocalDateTime getDataGiorno() {
		return LocalDateTime.of(2025, 12, 25, 0, 0);
	}
}
