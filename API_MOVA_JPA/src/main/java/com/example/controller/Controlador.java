package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Habilidad;
import com.example.modelo.HabilidadRepositorio;
import com.example.modelo.Historial;
import com.example.modelo.HistorialRepositorio;
import com.example.modelo.Personaje;
import com.example.modelo.PersonajeRepositorio;
import com.example.modelo.Usuario;
import com.example.modelo.UsuarioRepositorio;

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
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	//Dentro de la carpeta resources está data.sql
	/**
	* Obtenemos todos los productos
	* @return
	*/
	@GetMapping("/personajes") //+
	public ResponseEntity<?> mostrarPersonajes(){
		List<Personaje> result = personajeRepositorio.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}

	@GetMapping("/historial") //+
	public ResponseEntity<?> mostrarhistorial(){
		List<Historial> result = historialRepositorio.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/historial/{nombre}") //+
	public ResponseEntity<?> mostrarhistorialUsuario(@PathVariable String nombre){
		List<Historial> result = historialRepositorio.historialUsuario(nombre);
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/historial/personajes/{usu}") //+
	public ResponseEntity<?> personajesUtilizados(@PathVariable Long usu){
		List<String> result = historialRepositorio.mostrarPersonajesUsuario(usu);
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/usuario/mayorkda") //+
	public ResponseEntity<?> mayorkda(){
		List<Usuario> result = historialRepositorio.usuariosMayorKDA();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/usuarios") //+
	public ResponseEntity<?> usuarios(){
		actualizarContrasenias();
		List<Usuario> result = usuarioRepositorio.findAll();
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/habilidad/{hab}") //+
	public ResponseEntity<?> habilidad(@PathVariable Long hab){
		Habilidad result = habilidadRepositorio.buscar1(hab);
		if(result.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		System.out.print(result);
		return ResponseEntity.ok(result);
		
	}
	public void actualizarContrasenias() {
	    List<Usuario> usuarios = usuarioRepositorio.findAll(); // Obtén todos los usuarios de tu base de datos
	    if(usuarios.get(0).getNombre().equals(usuarios.get(0).getPassword())) {
		    for (Usuario usuario : usuarios) {
		        String nuevaContraseñaEncriptada = passwordEncoder.encode(usuario.getPassword());
		        usuario.setPassword(nuevaContraseñaEncriptada);
		    }
	    }
	    usuarioRepositorio.saveAll(usuarios); // Guarda los usuarios actualizados en la base de datos
	}
}
