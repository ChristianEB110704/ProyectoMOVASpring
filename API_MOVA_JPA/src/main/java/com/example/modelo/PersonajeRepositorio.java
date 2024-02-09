package com.example.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonajeRepositorio extends JpaRepository<Personaje,Long>{
    @Query("SELECT e FROM Personaje e")
    List<Personaje> mostrarPersonajes();
	
}
