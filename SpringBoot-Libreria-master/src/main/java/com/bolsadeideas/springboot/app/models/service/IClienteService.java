package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Coche;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

   	public List<Coche> findByNombre(String term);

	public Coche findCocheById(Long id);

	public void saveFactura(Factura factura);

}
