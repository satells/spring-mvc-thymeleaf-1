package com.springstudy.springmvcthymeleaf.web.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos")
public class Cargo extends AbstractEntity<Integer> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;

	@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
	private List<Funcionario> funcionario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Cargo [nome=" + nome + ", departamento=" + departamento + ", funcionario=" + funcionario + ", id=" + id + "]";
	}

}
