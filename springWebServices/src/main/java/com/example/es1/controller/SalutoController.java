package com.example.es1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/saluto")
public class SalutoController {

	public SalutoController() {
		System.out.println("Spring crea SalutoController");
	}
	
	@GetMapping(path="/generico")
	public String helloworld() {
		return "Hello world!";
	}
	
	@GetMapping(path="/specifico")
	public String hellospecifico(String nome) {
		return "Hello " + nome;
	}
}
