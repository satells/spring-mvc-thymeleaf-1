package com.springstudy.springmvcthymeleaf.web.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springstudy.springmvcthymeleaf.web.domain.Departamento;

@SpringBootTest
class DepartamentoServiceTest {

	@Autowired
	DepartamentoService service;

	@Test
	void test_save() {
		Departamento departamento = new Departamento();
		departamento.setNome("Estoque");

		service.save(departamento);
	}

}
