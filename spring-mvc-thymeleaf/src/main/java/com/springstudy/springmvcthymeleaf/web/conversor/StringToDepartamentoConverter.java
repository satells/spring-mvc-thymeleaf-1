package com.springstudy.springmvcthymeleaf.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springstudy.springmvcthymeleaf.web.domain.Departamento;
import com.springstudy.springmvcthymeleaf.web.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;

	@Override
	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}

		Integer id = Integer.valueOf(text);
		return service.buscarPorId(id);
	}

}
