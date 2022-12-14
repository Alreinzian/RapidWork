package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Inventario;
@Repository
public class InventarioDaoImpl implements IInventarioDao {
	
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Inventario> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Inventario").getResultList();
	}

	@Override
	public void save(Inventario inventario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventario findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
