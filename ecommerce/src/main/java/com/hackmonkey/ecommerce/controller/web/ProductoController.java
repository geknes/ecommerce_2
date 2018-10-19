package com.hackmonkey.ecommerce.controller.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hackmonkey.ecommerce.entity.Categoria;
import com.hackmonkey.ecommerce.entity.Producto;
import com.hackmonkey.ecommerce.service.interfaces.CategoriaService;
import com.hackmonkey.ecommerce.service.interfaces.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/agregar")
	public String agregarProducto(Model model)
	{
		Producto producto = new Producto();
		List<Categoria> listCategorias = categoriaService.listar();
		model.addAttribute("producto", producto);
		model.addAttribute("listCategorias", listCategorias);
		return "producto-agregar";
	}
	
	@GetMapping("/listado")
	public String listar(Model model)
	{
		List<Producto> listProductos = productoService.listar();
		model.addAttribute("listProductos", listProductos);
		return "producto-listado";
	}
	
}
