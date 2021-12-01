package com.springstudy.springmvcthymeleaf.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FuncionarioRepository {

	@Autowired
	private FuncionarioRepository repository;
}
