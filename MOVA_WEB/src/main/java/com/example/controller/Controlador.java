package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping(value="/listadoU")
	public String listarPerUsu(Model model) {
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios",service.mostrarUsuarios());
		return "listado/usuario";
	}
	
	@GetMapping(value="/personajes/{id}")
	public String listarPerUsu(Model model,@PathVariable Long id) {
		model.addAttribute("titulo","Nombre personajes de 1 usuario");
		if(service.nombrePersonajesUsuario(id).size()<=0) {
			model.addAttribute("error","No se ha encontrado ninguna partida en el historial");
		}
		model.addAttribute("nPersonajes",service.nombrePersonajesUsuario(id));
		return "personajeUsu";
	}
	
	@GetMapping(value="/usuarios/mayorKDA")
	public String listarUsuKDA(Model model) {
		model.addAttribute("titulo","Nombre personajes de 1 usuario");
		model.addAttribute("usuarios",service.usuariosMayorKDA());
		return "usuariosKDA";
	}
	
	
	
	
	
	@GetMapping("/login")
	public String mostrarLogin(@RequestParam(value="error",required=false) String error,Model model,Principal principal,RedirectAttributes attribute,
			@RequestParam(value="logout",required=false) String logout) {
		
		if(error!=null) {
			model.addAttribute("error","Error de acceso: Usuario y/o contraseña incorrectos");
			
		}
		
		if(principal!=null) {
			attribute.addFlashAttribute("warning","Atencion: Ya has iniciado sesion anteriormente");
			return "redirect:/";
		}
		
		if(logout!=null) {
			model.addAttribute("success","Exito: Se ha cerrado la sesion con exito");
		}
		return "login";
	}
}
