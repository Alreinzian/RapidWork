package com.bolsadeideas.springboot.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.dao.IInventarioDao;
@Controller
@SessionAttributes("inventario")
public class IInventarioController {
	@Autowired
	private IInventarioDao inventarioDao;

	@RequestMapping(value = "/inventario", method = RequestMethod.GET)
	public String listarInventario(Model model) {
		model.addAttribute("titulo", "Listado de inventario");
		model.addAttribute("inventario", inventarioDao.findAll());
		return "inventario";
}
	
}
