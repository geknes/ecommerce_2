package com.hackmonkey.ecommerce.controller.web;

import org.springframework.stereotype.Controller;
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
	
}
