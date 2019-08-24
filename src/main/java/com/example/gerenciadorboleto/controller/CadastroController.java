package com.example.gerenciadorboleto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	
	@GetMapping(value = "/boletos")
	public String cadastro() {
		//ModelAndView model = new ModelAndView("cadastro");
		
		return "cadastro";
	}
	
	
	
}
