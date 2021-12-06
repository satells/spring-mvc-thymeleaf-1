package com.springstudy.springmvcthymeleaf.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos")
public class Cargo extends AbstractEntity<Integer> {

	@NotBlank(message = "Informe um cargo.")
	@Size(min = 3, max = 60, message = "O nome do cargo deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@NotNull(message = "Selecione o departamento relativo ao cargo.")
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
