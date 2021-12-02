package com.springstudy.springmvcthymeleaf.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springstudy.springmvcthymeleaf.web.domain.Cargo;
import com.springstudy.springmvcthymeleaf.web.domain.Departamento;
import com.springstudy.springmvcthymeleaf.web.service.CargoService;
import com.springstudy.springmvcthymeleaf.web.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Cargo> cargos = cargoService.buscaTodos();

		model.addAttribute("cargos", cargos);

		return "/cargo/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}

	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos() {
		return departamentoService.buscarTodos();
	}

}
