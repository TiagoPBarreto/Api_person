package com.teste.api.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class PersonSwagger {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Rest API Persons")
						.version("v1")
						.description("Rest Api Person")
						.termsOfService("https://github.com/TiagoPBarreto")
						.license(new License().name("Apache 2.0")
								.url("https://github.com/TiagoPBarreto")));
		
	}
}
