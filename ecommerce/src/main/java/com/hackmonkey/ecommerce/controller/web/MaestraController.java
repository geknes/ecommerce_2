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

import com.hackmonkey.ecommerce.entity.Maestra;
import com.hackmonkey.ecommerce.service.interfaces.MaestraService;

@Controller
@RequestMapping("/maestra")
public class MaestraController {

	@Autowired
	private MaestraService maestraService;
	
	@GetMapping("/agregar")
	public String agregar(Model model)
	{
		Maestra maestra = new Maestra();
		List<Maestra> listTablasMaestras = maestraService.listarTablas();
		model.addAttribute("maestra", maestra);
		model.addAttribute("listTablasMestras", listTablasMaestras);
		return "maestra-agregar";
	}
	
	@PostMapping("/agregar")
	public String agregarSegmento(@ModelAttribute("maestra") Maestra maestra,
									@ModelAttribute("idMaestra") String idMaestra,
									HttpServletRequest request)
	{	if (!idMaestra.equals("")) {
			System.out.println("GUARDAR");
			maestraService.guardarHijo(maestra, Long.valueOf(idMaestra));
		}
		else {
			System.out.println("EDITAR");
			maestraService.guardarHijo(maestra, Long.valueOf(idMaestra));
		} 
		
		return "redirect:/maestra/listado";
	}
	
	@GetMapping("/listado")
	public String listar(Model model)
	{
		List<Maestra> listMaestras = maestraService.listar();
		model.addAttribute("listMaestras", listMaestras);
		return "maestra-listado";
	}
}
