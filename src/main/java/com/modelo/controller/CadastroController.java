package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.modelo.model.Produto;
import com.modelo.repository.CrudRepository;

@Controller
public class CadastroController {
	@Autowired
	CrudRepository crud;
	
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("produto", crud.findAll());
		return "cadastro";
	}
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("produto", crud.findAll());
		return "admin";
	}
	
	@GetMapping("/cadastro")
	public String salvar(Produto produto) {
		crud.save(produto);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		crud.deleteById(id);
		return "redirect:/";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dados", crud.findById(id));
		return "editar";
		
	}
	
	
	
	
	
	
	
	
	
	


}
