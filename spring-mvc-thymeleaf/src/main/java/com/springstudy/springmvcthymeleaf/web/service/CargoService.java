package com.springstudy.springmvcthymeleaf.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.springmvcthymeleaf.web.repository.CargoRepository;

@Service
@Transactional
public class CargoService {

	@Autowired
	private CargoRepository repository;

}
