package com.springstudy.springmvcthymeleaf.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springstudy.springmvcthymeleaf.web.domain.Departamento;
import com.springstudy.springmvcthymeleaf.web.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {

		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {

		List<Departamento> lista = service.buscarTodos();

		model.addAttribute("departamentos", lista);

		return "/departamento/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Departamento departamento, RedirectAttributes attr) {

		if (service.existeNome(departamento.getNome())) {
			attr.addFlashAttribute("fail", "Departamento já cadastrado.");
			attr.addAttribute("departamento", departamento);

		} else {
			service.save(departamento);
			attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		}

		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		Departamento departamento = service.buscarPorId(id);

		model.addAttribute("departamento", departamento);

		return "/departamento/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes attr) {
		service.save(departamento);

		attr.addFlashAttribute("success", "Departamento editado com sucesso.");

		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, ModelMap model) {

		if (service.depatamentoTemCargos(id)) {
			model.addAttribute("fail", "Departamento possui cargos vinculados.");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Departamento excluído com sucesso");
		}

		return listar(model);
	}
}
