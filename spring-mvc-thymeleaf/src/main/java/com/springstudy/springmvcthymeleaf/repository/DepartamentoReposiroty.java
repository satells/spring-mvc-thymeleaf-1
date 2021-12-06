package com.springstudy.springmvcthymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.domain.Departamento;

public interface DepartamentoReposiroty extends JpaRepository<Departamento, Integer> {

	List<Departamento> findAllByOrderByNomeAsc();

	Boolean existsByNome(String nome);

}
