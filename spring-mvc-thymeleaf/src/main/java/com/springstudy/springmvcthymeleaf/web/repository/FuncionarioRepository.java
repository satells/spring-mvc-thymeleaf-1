package com.springstudy.springmvcthymeleaf.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springstudy.springmvcthymeleaf.web.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	List<Funcionario> findByOrderByNomeAsc();

	@Query("select f from Funcionario f where f.nome like %:nome% order by f.nome asc")
	List<Funcionario> buscaPorNome(@Param("nome") String nome);

	@Query("select f from Funcionario f where f.cargo.id = :id order by f.nome asc")
	List<Funcionario> buscaPorIdCargo(@Param("id") Integer id);

}
