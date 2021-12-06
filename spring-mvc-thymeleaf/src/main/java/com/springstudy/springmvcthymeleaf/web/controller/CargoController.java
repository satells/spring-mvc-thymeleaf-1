package com.springstudy.springmvcthymeleaf.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springstudy.springmvcthymeleaf.domain.Cargo;
import com.springstudy.springmvcthymeleaf.domain.Departamento;
import com.springstudy.springmvcthymeleaf.service.CargoService;
import com.springstudy.springmvcthymeleaf.service.DepartamentoService;

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
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/cargo/cadastro";
		}

		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");

		return "redirect:/cargos/cadastrar";
	}

	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos() {

		return departamentoService.buscarTodos();
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap map) {
		Cargo cargo = cargoService.buscaPorId(id);
		map.addAttribute("cargo", cargo);

		return "cargo/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/cargo/cadastro";
		}

		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");

		return "redirect:/cargos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String exclur(@PathVariable Integer id, RedirectAttributes attr) {

		if (cargoService.cargoTemFuncionarios(id)) {
			attr.addFlashAttribute("fail", "Cargo não excluído. Tem funcionário(s) vinculado(s)");
		} else {
			cargoService.excluir(id);
			attr.addFlashAttribute("success", "Cargo excluido com sucesso.");

		}

		return "redirect:/cargos/listar";
	}

}
