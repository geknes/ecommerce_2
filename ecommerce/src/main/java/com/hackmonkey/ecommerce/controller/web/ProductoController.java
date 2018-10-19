package com.hackmonkey.ecommerce.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@GetMapping("/agregar")
	public String agregarProducto()
	{
		return "productos-admin";
	}
	
	@GetMapping("/listado")
	public String listar(Model model)
	{
		//List<Maestra> listMaestras = maestraService.listar();
		//model.addAttribute("listMaestras", listMaestras);
		return "producto-listado";
	}
	
}
