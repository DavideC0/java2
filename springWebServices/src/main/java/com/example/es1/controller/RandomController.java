package com.example.es1.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/random")
public class RandomController {

	@GetMapping(path="/estrazione")
	public ArrayList<Integer> estrazioneRandom() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random random = new Random();
		for (int i=0; i<5; i++) {
			 a.add(random.nextInt(0,91));
		}
		return a;
	}
}
