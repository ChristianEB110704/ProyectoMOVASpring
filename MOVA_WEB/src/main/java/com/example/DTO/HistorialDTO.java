package com.example.DTO;

import java.sql.Time;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistorialDTO {
	private int id;

	private Time duracion;

	private Date fecha;

	private int kda;

	private String linea;

	private String resultado;
	
	private PersonajeDTO personaje;

	private UsuarioDTO usuario;
}
