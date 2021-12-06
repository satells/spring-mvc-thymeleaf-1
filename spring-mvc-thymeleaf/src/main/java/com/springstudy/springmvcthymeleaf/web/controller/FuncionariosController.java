package com.springstudy.springmvcthymeleaf.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springstudy.springmvcthymeleaf.domain.Cargo;
import com.springstudy.springmvcthymeleaf.domain.Funcionario;
import com.springstudy.springmvcthymeleaf.domain.UF;
import com.springstudy.springmvcthymeleaf.service.CargoService;
import com.springstudy.springmvcthymeleaf.service.FuncionarioService;
import com.springstudy.springmvcthymeleaf.web.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());

	}

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		model.addAttribute("funcionario", funcionario);

		return "funcionario/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/funcionario/cadastro";
		}

		funcionarioService.salvar(funcionario);

		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");

		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		funcionarioService.excluir(id);

		attr.addFlashAttribute("success", "Funcionário removido com sucesso.");

		return "redirect:/funcionarios/listar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Funcionario> funcionarios = funcionarioService.buscarTodos();
		model.addAttribute("funcionarios", funcionarios);

		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/funcionario/cadastro";
		}

		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funionário inserido com sucesso.");

		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/buscar/nome")
	public String buscaPorNome(@RequestParam("nome") String nome, ModelMap model) {
		List<Funcionario> funcionarios = funcionarioService.buscaPorNome(nome);
		model.addAttribute("funcionarios", funcionarios);

		return "/funcionario/lista";
	}

	@GetMapping("/buscar/cargo")
	public String buscaPorCargo(@RequestParam("id") Integer id, ModelMap model) {
		List<Funcionario> funcionarios = funcionarioService.buscaPorIdCargo(id);
		model.addAttribute("funcionarios", funcionarios);

		return "/funcionario/lista";
	}

	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscaTodos();
	}

	@GetMapping("/buscar/data")
	public String getPorData(@RequestParam(name = "entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
			@RequestParam(name = "saida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscaPorData(entrada, saida));

		return "/funcionario/lista";
	}

	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
	}
}