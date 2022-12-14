package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Inventario;

public interface IInventarioDao {
public List<Inventario>findAll();
	
	public void save(Inventario inventario);
	
	public Inventario findOne(Long id);
	
	public void delete (Long id);
}
