package com.hackmonkey.ecommerce.controller.web;

import java.util.ArrayList;
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

import com.hackmonkey.ecommerce.entity.Categoria;
import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.service.interfaces.CategoriaService;
import com.hackmonkey.ecommerce.service.interfaces.SegmentoService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private SegmentoService segmentoService;
	
	@GetMapping("/agregar")
	public String agregar(Model model)
	{
		Categoria categoria = new Categoria();
		List<Segmento> lstSegmentos = segmentoService.listar();
		model.addAttribute("categoria",categoria);
		model.addAttribute("lstSegmentos",lstSegmentos);
		return "categoria-agregar";
	}
	
	@PostMapping("/agregar")
	public String agregarSegmento(	@ModelAttribute("categoria") Categoria categoria,
									@ModelAttribute("idSegmento") String idSegmento, 
									HttpServletRequest request)
	{	
		if (!idSegmento.equals("")) 
		{
			System.out.println(idSegmento);
			Segmento segmento = segmentoService.buscarPorId(Long.valueOf(idSegmento));
			System.out.println(segmento.toString());
			categoria.setSegmento(segmento);
			
			categoriaService.guardar(categoria);
		}
		else {
		///	System.out.println("EDITAR");
		//	categoriaService.guardar(categoria);
			return "redirect:/categoria/agregar";
		} 
		return "redirect:/categoria/listado";
	}
	
	@GetMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model)
	{
		Categoria categoria = new Categoria();
		List<Segmento> lstSegmentos = new ArrayList<>(); 
		categoria = categoriaService.buscarPorId(id);
		lstSegmentos.add(categoria.getSegmento());
		model.addAttribute("lstSegmentos",lstSegmentos);
		model.addAttribute("categoria",categoria);
		return "categoria-agregar";
	}
	
	@GetMapping("/listado")
	public String listar(Model model)
	{
		List<Categoria> listCategorias = categoriaService.listar();
		model.addAttribute("listCategorias", listCategorias);
		return "categoria-listado";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id, Model model)
	{
		categoriaService.eliminar(id);
		return "redirect:/categoria/listado";
	}
	
}
