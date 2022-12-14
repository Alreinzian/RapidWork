package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import com.bolsadeideas.springboot.app.models.dao.IProductoDao;
import com.bolsadeideas.springboot.app.models.entity.Producto;


@Controller
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private IProductoDao productoDao;

	@RequestMapping(value = "/listarProducto", method = RequestMethod.GET)
	public String listarProducto(Model model) {
		model.addAttribute("titulo", "Listado de Producto");
		model.addAttribute("producto", productoDao.findAll());
		return "listarProducto";
	}
	
	@RequestMapping(value = "/formProducto")
	public String crearProducto(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Registrar Producto");
		model.put("subTitulo", "Registar");
		
		return "formProducto";
	}

	@RequestMapping(value = "/formProducto/{id}")
	public String editarProducto(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Producto producto = null;
		if (id > 0) {
			producto = productoDao.findOne(id);
		} else {
			return "redirect:/listarProducto";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar ");
		model.put("subTitulo", "Editar");
		
		return "formProducto";
	}

	@RequestMapping(value = "/formProducto", method = RequestMethod.POST)
	public String guardarProducto(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("tituloProducto", "Formulario de Producto");
			return "formProducto";
		}

		productoDao.save(producto);
		status.setComplete();
		return "redirect:listarProducto";
	}

	@RequestMapping(value = "/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			productoDao.delete(id);
		}
		return "redirect:/listarProducto";
	}
}