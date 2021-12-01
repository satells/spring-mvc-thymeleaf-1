package com.springstudy.springmvcthymeleaf.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springstudy.springmvcthymeleaf.web.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

}
