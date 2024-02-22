package com.example.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface HabilidadRepositorio extends JpaRepository<Habilidad,Long> {

	@Query("SELECT c FROM Habilidad c WHERE c.id=?1")
	Habilidad buscar1(Long id);

}
