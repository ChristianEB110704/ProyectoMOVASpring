package com.example.modelo;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="usuario")
	private List<Historial> historial;

	//bi-directional many-to-one association to Servidore
	@ManyToOne
	@JoinColumn(name="servidor")
	private Servidor servidor;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Historial> getHistorials() {
		return this.historial;
	}

	public void setHistorials(List<Historial> historials) {
		this.historial = historials;
	}

	public Historial addHistorial(Historial historial) {
		getHistorials().add(historial);
		historial.setUsuario(this);

		return historial;
	}

	public Historial removeHistorial(Historial historial) {
		getHistorials().remove(historial);
		historial.setUsuario(null);

		return historial;
	}

	public Servidor getServidore() {
		return this.servidor;
	}

	public void setServidore(Servidor servidore) {
		this.servidor = servidore;
	}

}