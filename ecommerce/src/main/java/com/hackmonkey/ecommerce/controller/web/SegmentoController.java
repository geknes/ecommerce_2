package com.hackmonkey.ecommerce.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.service.SegmentoService;

@Controller
@RequestMapping("/segmento")
public class SegmentoController {
	
	@Autowired
	private SegmentoService segmentoService;
	
	@GetMapping("/agregar")
	public String agregar(Model model)
	{
		Segmento segmento = new Segmento();
		model.addAttribute("segmento",segmento);
		return "segmento-agregar";
	}
	
	@PostMapping("/agregar")
	public String agregarSegmento(@ModelAttribute("segmento") Segmento segmento, HttpServletRequest request)
	{
		segmentoService.guardar(segmento);
		return "redirect:/segmento/listado";
	}
	
	@GetMapping("/listado")
	public String listar(Model model)
	{
		List<Segmento> listSegmentos = segmentoService.listar();
		model.addAttribute("listSegmentos",listSegmentos);
		return "segmento-listado";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id, Model model)
	{
		segmentoService.eliminar(id);
		return "redirect:/segmento/listado";
	}

}
