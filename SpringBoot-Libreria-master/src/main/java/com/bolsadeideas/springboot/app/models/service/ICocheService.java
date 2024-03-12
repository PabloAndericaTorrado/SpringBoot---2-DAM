package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Coche;

public interface  ICocheService {

	public List<Coche> findAll();
	
	public Page<Coche> findAll(Pageable pageable);

	public void save(Coche coche);
	
	public Coche findOne(Long id);
	
	public void delete(Long id);
	public List<Coche> findByMatricula(String term);
}
