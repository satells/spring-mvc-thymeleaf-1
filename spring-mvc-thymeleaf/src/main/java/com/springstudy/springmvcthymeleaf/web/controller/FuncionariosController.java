package com.springstudy.springmvcthymeleaf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar() {
		return "/funcionario/lista";
	}

}
