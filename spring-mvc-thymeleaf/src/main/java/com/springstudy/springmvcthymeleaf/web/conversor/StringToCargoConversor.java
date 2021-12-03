package com.springstudy.springmvcthymeleaf.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.springstudy.springmvcthymeleaf.web.domain.Cargo;
import com.springstudy.springmvcthymeleaf.web.service.CargoService;

public class StringToCargoConversor implements Converter<String, Cargo> {

	@Autowired
	private CargoService cargoService;

	@Override
	public Cargo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}

		Integer id = Integer.valueOf(text);
		return cargoService.buscaPorId(id);
	}

}
