package com.springstudy.springmvcthymeleaf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springstudy.springmvcthymeleaf.web.conversor.StringToDepartamentoConverter;

@Configuration

public class WebConfig implements WebMvcConfigurer {

	@Autowired
	StringToDepartamentoConverter converter;

	@Override
	public void addFormatters(FormatterRegistry registry) {

		System.out.println("configuring>>>>>>>>>>>");

		registry.addConverter(converter);

	}
}