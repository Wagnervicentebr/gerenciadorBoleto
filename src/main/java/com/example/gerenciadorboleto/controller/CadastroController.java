package com.example.gerenciadorboleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.gerenciadorboleto.model.Boleto;
import com.example.gerenciadorboleto.repository.BoletoRepository;

@Controller
@RequestMapping("/boletos")
public class CadastroController {

	@Autowired
	private BoletoRepository boletoRepository;
	
	@GetMapping(value = "/novo")
	public String cadastro() {
		//ModelAndView model = new ModelAndView("cadastro");
		
		return "cadastro";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvaBoleto(Boleto boleto) {

		boletoRepository.save(boleto);
		
		return "cadastro";
	}
	
	
	
}
