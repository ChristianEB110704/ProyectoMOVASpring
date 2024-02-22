package com.example.modelo;


import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the PERSONAJES database table.
 * 
 */
@Entity
@Table(name="PERSONAJES")
@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p")
@JsonIgnoreProperties({"historial"})
public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	private String rol;

	
	@OneToOne(mappedBy="personaje")
	private Habilidad habilidad;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="personaje")
	private List<Historial> historial;

	public Personaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Habilidad getHabilidad() {
		return this.habilidad;
	}

	public void setHabilidad(Habilidad habilidades) {
		this.habilidad = habilidades;
	}

	public List<Historial> getHistorial() {
		return this.historial;
	}

	public void setHistorial(List<Historial> historials) {
		this.historial = historials;
	}

	public Historial addHistorial(Historial historial) {
		getHistorial().add(historial);
		historial.setPersonaje(this);

		return historial;
	}

	public Historial removeHistorial(Historial historial) {
		getHistorial().remove(historial);
		historial.setPersonaje(null);

		return historial;
	}

}