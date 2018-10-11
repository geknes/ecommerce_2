package com.hackmonkey.ecommerce.controller.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@Value("${spring.application.name}")
    String appName;
	
	@RequestMapping("/")
	public String index(Model model){
		
		model.addAttribute("appName",appName);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String home(){
		return "index";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	/*
	@GetMapping(value="/login-error")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login.html";
	  }
	*/
}
