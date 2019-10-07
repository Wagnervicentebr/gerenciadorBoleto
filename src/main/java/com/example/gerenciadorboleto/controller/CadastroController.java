package com.example.gerenciadorboleto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.gerenciadorboleto.enuns.StatusBoleto;
import com.example.gerenciadorboleto.model.Boleto;
import com.example.gerenciadorboleto.repository.BoletoRepository;

@Controller
@RequestMapping("/boletos")
public class CadastroController {

	@Autowired
	private BoletoRepository boletoRepository;
	
	@GetMapping(value = "/novo")
	public ModelAndView cadastro() {
		ModelAndView model = new ModelAndView("cadastro");
		
		model.addObject("todosStatus", StatusBoleto.values() );
		model.addObject(new Boleto());
		return model;
	}
	
	@DeleteMapping("{codigo}")
	public String deletar(@PathVariable Integer codigo, RedirectAttributes attributes) {
		
		boletoRepository.deleteById(codigo);
		
		attributes.addFlashAttribute("mensagem", "Boleto excluido com sucesso!!");
		return "redirect:/boletos";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvaBoleto(@Validated Boleto boleto, Errors error, RedirectAttributes attributes) {
		
		if(error.hasErrors()){
			return "cadastro";
		}
		
		boletoRepository.save(boleto);
		
		attributes.addFlashAttribute("mensagem", "Boleto cadastrado com sucesso !");
		return "redirect:/boletos/novo";
	}
	
	@RequestMapping("{codBoleto}")
	public ModelAndView editar(@PathVariable Integer codBoleto) {
		ModelAndView model = new ModelAndView("cadastro");
		
		Optional<Boleto> boletos = boletoRepository.findById(codBoleto);
		
		model.addObject("boleto", boletos.get());
		
		return model;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView buscaTitulos() {
		ModelAndView model = new ModelAndView("pesquisaTitulos");
		
		List<Boleto> listaBoletos = boletoRepository.findAll();
		
		model.addObject("listaBoletos", listaBoletos);
		return model;
	}
	@ModelAttribute(value = "todosStatus")
	public List<StatusBoleto> listaStatusBoleto(){
		return Arrays.asList(StatusBoleto.values());
	
	}
}
