package com.springstudy.springmvcthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
