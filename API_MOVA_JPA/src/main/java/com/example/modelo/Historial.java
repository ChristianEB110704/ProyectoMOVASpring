package com.example.modelo;


import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the HISTORIAL database table.
 * 
 */
@Entity
@Table(name="HISTORIAL")
@NamedQuery(name="Historial.findAll", query="SELECT h FROM Historial h")
public class Historial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Time duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int kda;

	private String linea;

	private String resultado;

	//bi-directional many-to-one association to Personaje
	@ManyToOne
	@JoinColumn(name="id_personaje")
	private Personaje personaje;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Historial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getKda() {
		return this.kda;
	}

	public void setKda(int kda) {
		this.kda = kda;
	}

	public String getLinea() {
		return this.linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}