package com.example.es1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/calcoli")
public class CalcolatriceController {
	
	public CalcolatriceController() {
		System.out.println("Spring crea CalcolatriceController");
	}
	
	@GetMapping(path="/sum")
	public int somma(int n1, int n2) {
		return n1 + n2;
	}
}
