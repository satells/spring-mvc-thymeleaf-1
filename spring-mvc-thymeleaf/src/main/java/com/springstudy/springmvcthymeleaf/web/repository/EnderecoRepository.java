package com.springstudy.springmvcthymeleaf.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.web.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
