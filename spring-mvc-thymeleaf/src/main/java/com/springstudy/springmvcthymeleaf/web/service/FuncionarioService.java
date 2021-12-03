package com.springstudy.springmvcthymeleaf.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.springmvcthymeleaf.web.domain.Funcionario;
import com.springstudy.springmvcthymeleaf.web.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public void salvar(Funcionario funcionario) {
		repository.save(funcionario);

	}

	public List<Funcionario> buscarTodos() {
		return repository.findByOrderByNomeAsc();
	}

	public Funcionario buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void excluir(Integer id) {

		repository.deleteById(id);

	}
}
