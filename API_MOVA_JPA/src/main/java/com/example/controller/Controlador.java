package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.HistorialRepositorio;
import com.example.modelo.Personaje;
import com.example.modelo.PersonajeRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controlador {
	@Autowired
	private HistorialRepositorio historialRepositorio;
	@Autowired
	private PersonajeRepositorio personajeRepositorio;
	
	
	//Dentro de la carpeta resources está data.sql
	/**
	* Obtenemos todos los productos
	* @return
	*/
	@GetMapping("/producto")
	public ResponseEntity<?> mostrarPersonajes(){
		List<Personaje> result = personajeRepositorio.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
		
	}
	@GetMapping("/")
	public ResponseEntity<?> prueba(){
		return null;
	}
}
