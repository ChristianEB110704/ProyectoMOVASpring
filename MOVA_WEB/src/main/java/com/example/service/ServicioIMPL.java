package com.example.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.DTO.HabilidadDTO;
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
		for(int i=0;i<response.length;i++) {
			System.out.println(response[i].getServidor());
		}
		return Arrays.asList(response);
	}
	
	public List<UsuarioDTO> usuariosMayorKDA(){
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		UsuarioDTO[] response=restTemplate.getForObject(basePath+"/usuario/mayorkda",UsuarioDTO[].class);
		return Arrays.asList(response);
	}
}
////usuario/mayorkda