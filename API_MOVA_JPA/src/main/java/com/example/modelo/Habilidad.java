package com.example.modelo;


import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the HABILIDADES database table.
 * 
 */
@Entity
@Table(name="HABILIDADES")
@NamedQuery(name="Habilidad.findAll", query="SELECT h FROM Habilidad h")
public class Habilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	@Column(name="hab_definitiva")
	private String habDefinitiva;

	//bi-directional many-to-one association to Personaje
	@ManyToOne
	@JoinColumn(name="id_personaje")
	private Personaje personaje;

	public Habilidad() {
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

	public String getHabDefinitiva() {
		return this.habDefinitiva;
	}

	public void setHabDefinitiva(String habDefinitiva) {
		this.habDefinitiva = habDefinitiva;
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

}