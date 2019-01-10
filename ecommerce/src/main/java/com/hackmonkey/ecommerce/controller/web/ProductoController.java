package com.hackmonkey.ecommerce.controller.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hackmonkey.ecommerce.entity.Categoria;
import com.hackmonkey.ecommerce.entity.Maestra;
import com.hackmonkey.ecommerce.entity.Producto;
import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.service.interfaces.CategoriaService;
import com.hackmonkey.ecommerce.service.interfaces.MaestraService;
import com.hackmonkey.ecommerce.service.interfaces.ProductoService;
import com.hackmonkey.ecommerce.service.interfaces.SegmentoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private SegmentoService segmentoService;
	
	@Autowired
	private MaestraService maestraService;
	
	@GetMapping("/agregar")
	public String agregarProducto(Model model)
	{
		Producto producto = new Producto();
		List<Segmento> listSegmentos = segmentoService.listar();
		List<Maestra> listMaestras = maestraService.listar();
		
		List<Categoria> listCategorias = categoriaService.listar();
		model.addAttribute("producto", producto);
		model.addAttribute("listSegmentos",listSegmentos);
		model.addAttribute("listMaestras", listMaestras);
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
