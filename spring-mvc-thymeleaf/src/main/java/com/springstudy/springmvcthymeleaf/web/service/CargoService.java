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

}
