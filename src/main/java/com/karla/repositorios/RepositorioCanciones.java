package com.karla.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karla.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
	List<Cancion> findAll();
}
