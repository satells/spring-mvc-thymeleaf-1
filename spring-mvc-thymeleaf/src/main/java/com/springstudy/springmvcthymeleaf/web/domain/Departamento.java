package com.springstudy.springmvcthymeleaf.web.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "departamentos")
public class Departamento extends AbstractEntity<Integer> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Cargo> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", id=" + id + "]";
	}

}
