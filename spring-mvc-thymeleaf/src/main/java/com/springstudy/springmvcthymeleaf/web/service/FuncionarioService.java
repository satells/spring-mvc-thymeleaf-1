package com.springstudy.springmvcthymeleaf.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.springmvcthymeleaf.web.domain.Funcionario;
import com.springstudy.springmvcthymeleaf.web.repository.FuncionarioRepository;

@Service
@Transactional(readOnly = true)
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	@Transactional(readOnly = false)
	public void salvar(Funcionario funcionario) {
		repository.save(funcionario);

	}

	public List<Funcionario> buscarTodos() {
		return repository.findByOrderByNomeAsc();
	}

	public Funcionario buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void excluir(Integer id) {

		repository.deleteById(id);

	}

	public List<Funcionario> buscaPorNome(String nome) {
		return repository.buscaPorNome(nome);
	}

	public List<Funcionario> buscaPorIdCargo(Integer id) {
		return repository.buscaPorIdCargo(id);
	}
}
