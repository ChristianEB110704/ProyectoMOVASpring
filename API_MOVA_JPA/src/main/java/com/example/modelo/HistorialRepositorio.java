package com.example.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HistorialRepositorio extends JpaRepository<Historial,Long>{
	@Query("SELECT DISTINCT H.nombre FROM Historial H WHERE H.usuario.idUsuario=:id")
	List<String> mostrarPersonajesUsuario(@Param("id") Integer id);
	
	@Query("SELECT H.id_usuario FROM Historial H WHERE H.kda = (SELECT MAX(H2.kda) FROM Historial H2)")
	List<Usuario> usuariosMayorKDA();
	
	
}
