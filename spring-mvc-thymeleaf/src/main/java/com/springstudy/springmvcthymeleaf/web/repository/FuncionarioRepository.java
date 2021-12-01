package com.springstudy.springmvcthymeleaf.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.web.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
