package com.springstudy.springmvcthymeleaf.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.springmvcthymeleaf.web.domain.Cargo;
import com.springstudy.springmvcthymeleaf.web.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	public void salvar(Cargo cargo) {
		repository.save(cargo);
	}

	public List<Cargo> buscaTodos() {
		return repository.findAllByOrderByNome();
	}

	public Cargo buscaPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public boolean cargoTemFuncionarios(Integer id) {
		Cargo cargo = repository.findById(id).get();
		if (cargo.getFuncionario().isEmpty()) {
			return false;
		}

		return true;
	}

}
