package com.springstudy.springmvcthymeleaf.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.springmvcthymeleaf.web.domain.Departamento;
import com.springstudy.springmvcthymeleaf.web.exception.DepartamentoRuntimeException;
import com.springstudy.springmvcthymeleaf.web.repository.DepartamentoReposiroty;

@Service
@Transactional
public class DepartamentoService {

	@Autowired
	private DepartamentoReposiroty repository;

	@Transactional
	public Departamento save(Departamento departamento) {
		try {
			return repository.save(departamento);
		} catch (Exception e) {
			throw new DepartamentoRuntimeException("Departamento já cadastrado");
		}

	}

	@Transactional(readOnly = true)
	public Departamento findById(Integer id) {
		Optional<Departamento> found = repository.findById(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new DepartamentoRuntimeException("Id de Departamento não encontrado");
	}
}
