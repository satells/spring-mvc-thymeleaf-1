package com.springstudy.springmvcthymeleaf.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.springmvcthymeleaf.domain.Funcionario;
import com.springstudy.springmvcthymeleaf.repository.FuncionarioRepository;

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

	public List<Funcionario> buscaPorData(LocalDate entrada, LocalDate saida) {

		if (entrada != null && saida != null) {
			return repository.findByDataEntradaAndByDataSaida(entrada, saida);
		} else if (entrada != null) {
			return repository.findByDataEntrada(entrada);
		} else if (saida != null) {
			return repository.findByDataSaida(saida);
		}
		return new ArrayList<Funcionario>();
	}
}
