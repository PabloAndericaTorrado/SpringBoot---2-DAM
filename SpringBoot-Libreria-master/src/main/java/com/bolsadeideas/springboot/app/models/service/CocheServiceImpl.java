package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ICocheDao;
import com.bolsadeideas.springboot.app.models.entity.Coche;

@Service
public class CocheServiceImpl implements ICocheService {

    @Autowired
    private ICocheDao cocheDao;

    @Override
    @Transactional(readOnly = true)
    public List<Coche> findAll() {
        return (List<Coche>) cocheDao.findAll();
    }

    @Override
    @Transactional
    public void save(Coche coche) {
        cocheDao.save(coche);
    }

	@Override
	@Transactional(readOnly = true)
	public Coche findOne(Long id) {
		return (Coche)(cocheDao.findById(id).orElse(null));
	}

    @Override
    @Transactional
    public void delete(Long id) {
        cocheDao.deleteById(id);
    }

    @Override
    public List<Coche> findByMatricula(String term) {
        return cocheDao.findByMatricula(term);
    }

    @Override
    public Page<Coche> findAll(Pageable pageable) {
        return cocheDao.findAll(pageable);
    }
}
