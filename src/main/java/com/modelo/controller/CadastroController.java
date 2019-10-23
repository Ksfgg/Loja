package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.modelo.model.Produto;

@Controller
public class CadastroController {
	int a = 0;
	@Autowired
	CrudRepository crudRepository;
	
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("produto", crudRepository.findAll());
		return "cadastro";
	}
	
	
	@PostMapping("/cadastro")
	public String salvar(Produto produto) {
		crudRepository.save(produto);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		crudRepository.deleteById(id);
		return "redirect:/";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dados", crudRepository.findById(id));
		return "editar";
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		System.out.print("ID" + id);
		return "/cadastro";	
	}*/

}
