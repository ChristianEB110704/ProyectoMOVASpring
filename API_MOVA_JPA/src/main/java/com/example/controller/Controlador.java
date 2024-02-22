package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Habilidad;
import com.example.modelo.HabilidadRepositorio;
import com.example.modelo.Historial;
import com.example.modelo.HistorialRepositorio;
import com.example.modelo.Personaje;
import com.example.modelo.PersonajeRepositorio;
import com.example.modelo.Usuario;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controlador {
	@Autowired
	private HistorialRepositorio historialRepositorio;
	
	@Autowired
	private HabilidadRepositorio habilidadRepositorio;
	
	@Autowired
	private PersonajeRepositorio personajeRepositorio;
	
	
	//Dentro de la carpeta resources está data.sql
	/**
	* Obtenemos todos los productos
	* @return
	*/
	@GetMapping("/personajes")
	public ResponseEntity<?> mostrarPersonajes(){
		List<Personaje> result = personajeRepositorio.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}

	@GetMapping("/historial")
	public ResponseEntity<?> mostrarhistorial(){
		List<Historial> result = historialRepositorio.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/historial/personajes/{usu}")
	public ResponseEntity<?> personajesUtilizados(@PathVariable Long usu){
		List<String> result = historialRepositorio.mostrarPersonajesUsuario(usu);
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/usuario/mayorkda")
	public ResponseEntity<?> mayorkda(){
		List<Usuario> result = historialRepositorio.usuariosMayorKDA();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/habilidad/{hab}")
	public ResponseEntity<?> habilidad(@PathVariable Long hab){
		Habilidad result = habilidadRepositorio.buscar1(hab);
		if(result.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
}
