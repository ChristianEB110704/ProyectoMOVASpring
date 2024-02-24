package com.example.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	private int id;

	private int nivel;

	private String nombre;
	
	private ServidorDTO servidor;
}
