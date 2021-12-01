package com.springstudy.springmvcthymeleaf.web.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Integer> {

	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false, columnDefinition = "decimal default 0.00")
	private BigDecimal salario;

	@Column(nullable = false, columnDefinition = "date")
	private LocalDate dataeentrada;

	@Column(columnDefinition = "date")
	private LocalDate datasaida;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

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
