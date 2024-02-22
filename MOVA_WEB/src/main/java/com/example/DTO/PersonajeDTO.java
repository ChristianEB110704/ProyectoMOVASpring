package com.example.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {
	private int id;

	private String descripcion;

	private String nombre;

	private String rol;

	private HabilidadDTO habilidad;

}
