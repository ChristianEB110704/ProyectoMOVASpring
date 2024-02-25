package com.example.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.DTO.HabilidadDTO;
import com.example.DTO.HistorialDTO;
import com.example.DTO.PersonajeDTO;
import com.example.DTO.UsuarioDTO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ServicioIMPL {
	@Value("${rutaapi}")
	String basePath;
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public List<PersonajeDTO>obtenerPersonajes(){
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		PersonajeDTO[] response=restTemplate.getForObject(basePath+"/personajes",PersonajeDTO[].class);
		for(int i=0;i<response.length;i++) {
			System.out.println(response[i]);
		}
		return Arrays.asList(response);
	}
	public HabilidadDTO obtenerHabilidad(Long id){
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HabilidadDTO response=restTemplate.getForObject(basePath+"/habilidad/"+id,HabilidadDTO.class);
		return response;
	}
	
	public List<String>  nombrePersonajesUsuario(Long id){
		try {
		    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		    String[] response = restTemplate.getForObject(basePath + "/historial/personajes/" + id, String[].class);
		    System.out.println("Response: " + Arrays.toString(response));
		    return Arrays.asList(response);
		} catch (HttpClientErrorException e) {
		    e.printStackTrace();
		    return Collections.emptyList();
		}
	}
	
	public List<UsuarioDTO> mostrarUsuarios(){
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		UsuarioDTO[] response=restTemplate.getForObject(basePath+"/usuarios",UsuarioDTO[].class);
		
		return Arrays.asList(response);
	}
	
	public List<UsuarioDTO> usuariosMayorKDA(){
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		UsuarioDTO[] response=restTemplate.getForObject(basePath+"/usuario/mayorkda",UsuarioDTO[].class);
		return Arrays.asList(response);
	}
    
    public String getStoredPasswordByUsername(String username) {
    	List<UsuarioDTO>users=mostrarUsuarios();
    	for(UsuarioDTO u:users) {
    		if(u.getNombre().equals(username)) {
    			return u.getPassword();
    		}
    	}
    	return null;
    }
	public List<HistorialDTO> mostrarHistorial(String nombreUsuario) {
		try {
	        HistorialDTO[] partidas = restTemplate.getForObject(basePath + "/historial/" + nombreUsuario, HistorialDTO[].class);
	        return Arrays.asList(partidas);
	    } catch (HttpClientErrorException ex) {
	        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
	            // Manejar el caso cuando la URL no es encontrada
	            return Collections.emptyList(); // o cualquier otra lógica para manejar una lista vacía
	        } else {
	            // Manejar otros errores HTTP si es necesario
	            throw ex;
	        }
	    }
	}
}
////usuario/mayorkda