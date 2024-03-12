package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Coche;

public interface ICocheDao extends PagingAndSortingRepository<Coche, Long> {

    List<Coche> findAll();

	void save(Coche coche);

	Optional <Object> findById(Long id);

	void deleteById(Long id);

	@Query("select c from Coche c where c.matricula like %?1%")
	public List<Coche> findByMatricula(String matricula);
}
