package com.example.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.DTO.HistorialDTO;
import com.example.DTO.ServidorDTO;
import com.example.DTO.UsuarioDTO;
import com.example.service.ServicioIMPL;

import jakarta.validation.Valid;

@Controller
public class Controlador {
	@Autowired
	private ServicioIMPL service;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	  
	
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
	
	@GetMapping(value="/historial")
	public String historial(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String nombreUsuario = authentication.getName();
	    List<HistorialDTO> historial=service.mostrarHistorial(nombreUsuario);
		model.addAttribute("titulo","Historial de partidas");
		model.addAttribute("partidas",historial);
		return "listado/historial";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String,Object>model) {	
		//Añade los valores a la pagina para que esta lo rellene
		List<ServidorDTO> serv=service.mostrarServidores();
		//paso datos a la vista
		model.put("servidores", serv);
		model.put("titulo", "Crear Usuario");
		return "form";
	}
	
	@PostMapping(value="/form")
	public String guardar(@RequestParam Integer idServidor,@Valid 
            @RequestParam String nombre, 
            @RequestParam String password,  Model model) {
       List<UsuarioDTO>users=service.mostrarUsuarios();
       UsuarioDTO usuario=new UsuarioDTO();
       int d=users.size();
       int sol=users.get(d-1).getId()+1;
       usuario.setId(sol);
       usuario.setNivel(0);
       usuario.setServidor(convert(idServidor));
       usuario.setNombre(nombre);
       usuario.setPassword(password);
       service.agregarUsuario(usuario);
       return "redirect:/";
   }

	@GetMapping(value="/borrar/{id}")
	public String borrar(@PathVariable Long id) {
       service.borrarUsuario(id);
       return "redirect:/listadoU";
   }
	public ServidorDTO convert(Integer id) {
		List<ServidorDTO> servidores = service.mostrarServidores();
        return servidores.stream()
                .filter(servidor -> servidor.getId()==id)
                .findFirst()
                .orElse(null);
	}
	
	@GetMapping("/login")
	public String mostrarLogin(@RequestParam(value="error",required=false) String error,Model model,Principal principal,RedirectAttributes attribute,
			@RequestParam(value="logout",required=false) String logout) {

        System.out.print(passwordEncoder.encode("EuroGamer"));
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

	@PostMapping(name="/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Obtener la contraseña almacenada en la base de datos para el usuario
        String storedPassword = service.getStoredPasswordByUsername(username);
        String encryptedPassword = passwordEncoder.encode(password);
        // Comprobar si la contraseña proporcionada coincide con la almacenada
        System.out.println(passwordEncoder.encode(password));
        if (encryptedPassword.equals(storedPassword)) {
            // Autenticación exitosa, redirigir a la página principal o a una página segura
            return "redirect:/";
        } else {
            // Autenticación fallida, redirigir a la página de inicio de sesión con un mensaje de error
            return "redirect:/login?error";
        }
    }
}
