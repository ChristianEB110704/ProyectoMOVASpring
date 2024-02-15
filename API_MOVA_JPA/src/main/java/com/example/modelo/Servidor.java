package com.example.modelo;


import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the SERVIDORES database table.
 * 
 */
@Entity
@Table(name="SERVIDORES")
@NamedQuery(name="Servidor.findAll", query="SELECT s FROM Servidor s")
@JsonIgnoreProperties({"usuarios"})
public class Servidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	@Column(name="direccion_ip")
	private String direccionIp;

	@Column(name="nombre_servidor")
	private String nombreServidor;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="servidor")
	@JsonManagedReference
	private List<Usuario> usuarios;

	public Servidor() {
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

	public String getDireccionIp() {
		return this.direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public String getNombreServidor() {
		return this.nombreServidor;
	}

	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}