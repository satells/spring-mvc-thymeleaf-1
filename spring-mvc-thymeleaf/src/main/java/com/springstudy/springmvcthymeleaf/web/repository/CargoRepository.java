package com.springstudy.springmvcthymeleaf.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springstudy.springmvcthymeleaf.web.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
