package com.example.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HistorialRepositorio extends JpaRepository<Historial,Long>{
	
	@Query("SELECT DISTINCT h.personaje.nombre FROM Historial h WHERE h.usuario.id=?1")
	List<String> mostrarPersonajesUsuario(Long id);
	
	@Query("SELECT H.usuario FROM Historial H WHERE H.kda = (SELECT MAX(H2.kda) FROM Historial H2)")
	List<Usuario> usuariosMayorKDA();
	
	
}
