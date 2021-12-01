package com.springstudy.springmvcthymeleaf.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.web.domain.Departamento;

public interface DepartamentoReposiroty extends JpaRepository<Departamento, Integer> {

}
