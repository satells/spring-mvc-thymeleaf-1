package com.springstudy.springmvcthymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.springmvcthymeleaf.domain.Departamento;
import com.springstudy.springmvcthymeleaf.repository.DepartamentoReposiroty;

@Service
@Transactional
public class DepartamentoService {

	@Autowired
	private DepartamentoReposiroty repository;

	public boolean existeNome(String nome) {
		return repository.existsByNome(nome);
	}

	@Transactional
	public Departamento save(Departamento departamento) {
		return repository.save(departamento);
	}

	@Transactional(readOnly = true)
	public Departamento buscarPorId(Integer id) {
		Optional<Departamento> found = repository.findById(id);
		return found.get();
	}

	public List<Departamento> buscarTodos() {
		return repository.findAllByOrderByNomeAsc();
	}

	public void excluir(Integer id) {
		repository.deleteById(id);

	}

	public boolean depatamentoTemCargos(Integer id) {
		Departamento departamento = repository.findById(id).get();
		if (departamento.getCargos().isEmpty()) {
			return false;
		}
		return true;

	}

}
