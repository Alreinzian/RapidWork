package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Producto;



@Repository
public class ProductoDaoImpl implements IProductoDao {
    @PersistenceContext
	private EntityManager em;
    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Producto> findAll(){
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}
	@Override
	public Producto findOne(Long id) {
		return em.find(Producto.class, id);
	}
	
	@Override
	@Transactional
	public void save(Producto producto) {
		if(producto.getId()!= null && producto.getId()>0){
			em.merge(producto);
		}else {
			em.persist(producto);
			
		}
		
			
	}

	
	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}

}
