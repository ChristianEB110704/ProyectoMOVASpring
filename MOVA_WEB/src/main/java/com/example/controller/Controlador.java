package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.service.ServicioIMPL;

@Controller
public class Controlador {
	@Autowired
	private ServicioIMPL service;
	
	
	@GetMapping(value="/")
	public String index(Model model) {
		model.addAttribute("titulo","LaLiga");
		return "index";
	}
	
	@GetMapping(value="/listadoP")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de personajes");
		model.addAttribute("personajes",service.obtenerPersonajes());
		return "listado/personaje";
	}
	
	@GetMapping(value="/habilidad/{id}")
	public String listar(Model model, @PathVariable Long id) {
		model.addAttribute("titulo","Habilidad definitiva");
		model.addAttribute("habilidad",service.obtenerHabilidad(id));
		return "habilidad";
	}
}
