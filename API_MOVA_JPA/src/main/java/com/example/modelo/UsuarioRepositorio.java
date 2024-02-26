package com.example.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{

	@Query("SELECT e FROM Usuario e")
	 List<Usuario> mostrarTodos();
	
	@Query("SELECT e FROM Usuario e WHERE e.id= :id")
	Usuario usuarioEspecifico(@Param("id") Integer id);
	
	@Modifying
	@Query("INSERT INTO Usuario (id,nivel, nombre, servidor, password) VALUES (:id,:nivel, :nombre, :servidor, :password)")
	void guardarUsuario(@Param("id") int id,
						@Param("nivel") int nivel,
	                    @Param("nombre") String nombre,
	                    @Param("servidor") Servidor servidor,
	                    @Param("password") String password);
}
