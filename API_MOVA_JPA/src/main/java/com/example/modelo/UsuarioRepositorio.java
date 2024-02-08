package com.example.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{

	@Query("SELECT e FROM Usuario e")
	 List<Usuario> mostrarTodos();
	
	@Query("SELECT e FROM Usuario e WHERE e.id= :id")
	Usuario usuarioEspecifico(@Param("id") Integer id);
}
