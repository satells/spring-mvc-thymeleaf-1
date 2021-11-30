package com.springstudy.springmvcthymeleaf.web.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataeentrada;
	private LocalDate datasaida;
	private String nome;
	private BigDecimal salario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Enderecos endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataeentrada() {
		return dataeentrada;
	}

	public void setDataeentrada(LocalDate dataeentrada) {
		this.dataeentrada = dataeentrada;
	}

	public LocalDate getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(LocalDate datasaida) {
		this.datasaida = datasaida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
