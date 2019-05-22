package com.ito.itosofttest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ito.itosofttest.model.PedroMoncadaUsuario;

public interface PedroMoncadaUsuarioRepository extends JpaRepository<PedroMoncadaUsuario, Long> {

	Optional<PedroMoncadaUsuario> findByUsuario(String name);

	@Query("select u from PedroMoncadaUsuario u where u.id like :id")
	List<PedroMoncadaUsuario> findByIde(@Param("id") Integer id);

}
