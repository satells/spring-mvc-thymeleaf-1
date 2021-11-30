package com.springstudy.springmvcthymeleaf.web.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataeentrada;
	private Date datasaida;
	private String nome;
	private BigDecimal salario;
	private Integer cargo_id;
	private Integer endereco_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataeentrada() {
		return dataeentrada;
	}

	public void setDataeentrada(Date dataeentrada) {
		this.dataeentrada = dataeentrada;
	}

	public Date getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(Date datasaida) {
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

	public Integer getCargo_id() {
		return cargo_id;
	}

	public void setCargo_id(Integer cargo_id) {
		this.cargo_id = cargo_id;
	}

	public Integer getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Integer endereco_id) {
		this.endereco_id = endereco_id;
	}

}
