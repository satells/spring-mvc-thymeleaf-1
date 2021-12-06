package com.springstudy.springmvcthymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

	List<Cargo> findAllByOrderByNome();

}
