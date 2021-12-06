package com.springstudy.springmvcthymeleaf.web.repository;

import java.time.LocalDate;
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

	@Query("select f from Funcionario f where f.dataEntrada >= :dataEntrada and f.dataSaida <= :dataSaida order by f.dataEntrada asc, f.nome asc")
	List<Funcionario> findByDataEntradaAndByDataSaida(@Param("dataEntrada") LocalDate dataEntrada, @Param("dataSaida") LocalDate dataSaida);

	@Query("select f from Funcionario f where f.dataEntrada = :dataEntrada order by f.dataEntrada asc, f.nome asc")
	List<Funcionario> findByDataEntrada(@Param("dataEntrada") LocalDate entrada);

	@Query("select f from Funcionario f where f.dataSaida = :dataSaida order by f.dataSaida asc, f.nome asc")
	List<Funcionario> findByDataSaida(@Param("dataSaida") LocalDate saida);

}
