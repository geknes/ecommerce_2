package com.hackmonkey.ecommerce.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.service.SegmentoService;

@Controller
@RequestMapping("/segmento")
public class SegmentoController {
	
	@Autowired
	private SegmentoService segmentoService;
	
	@GetMapping("/agregar")
	public String agregarProducto()
	{
		return "segmento-listado";
	}
	
	@GetMapping("/listado")
	public String listar(Model model)
	{
		List<Segmento> listSegmentos = segmentoService.listar();
		model.addAttribute("listSegmentos",listSegmentos);
		return "segmento-listado";
	}

}
