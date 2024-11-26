package com.rest.bibliorest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rest.bibliorest.libro.Libro;
import com.rest.bibliorest.libro.LibroDto;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class DataConfiguration {

	@Bean
	public ModelMapper getModelMapper() {

		ModelMapper modelMapper = new ModelMapper();

		modelMapper.typeMap(LibroDto.class, Libro.class).addMappings(mapper -> {
			mapper.skip(Libro::setEditori); // Ignora la lista di editori
		});

		return modelMapper;
	}

	@Bean
	public OpenAPI getSwagger() {

		return new OpenAPI()
				
				.info(new Info()
						.title("Servizi Rest Dto")
						.description("Api Rest per gestione attività")
						.termsOfService("http://www......")
				
				.contact(new io.swagger.v3.oas.models.info.Contact()
						.name("Support Api")
						.email("scufranc@yahoo.com"))
				
				.license(new License()
						.name("Licence Api 1.0")
						.url("http://www......")));

	}

}
