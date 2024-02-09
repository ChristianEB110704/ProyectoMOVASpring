package com.example.modelo;


import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the PERSONAJES database table.
 * 
 */
@Entity
@Table(name="PERSONAJES")
@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p")
public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	private String rol;

	//bi-directional many-to-one association to Habilidade
	@OneToOne(mappedBy="personaje")
	private Habilidad habilidad;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="personaje")
	@JsonIgnoreProperties({"personaje"})
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

	public Habilidad getHabilidades() {
		return this.habilidad;
	}

	public void setHabilidades(Habilidad habilidades) {
		this.habilidad = habilidades;
	}

	public List<Historial> getHistorials() {
		return this.historial;
	}

	public void setHistorials(List<Historial> historials) {
		this.historial = historials;
	}

	public Historial addHistorial(Historial historial) {
		getHistorials().add(historial);
		historial.setPersonaje(this);

		return historial;
	}

	public Historial removeHistorial(Historial historial) {
		getHistorials().remove(historial);
		historial.setPersonaje(null);

		return historial;
	}

}