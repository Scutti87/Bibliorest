package com.rest.bibliorest.config;

import com.rest.bibliorest.enums.GenereLibro;

import jakarta.persistence.AttributeConverter;

public class GenereLibroConverter implements AttributeConverter<GenereLibro, String>{

	@Override
	public String convertToDatabaseColumn(GenereLibro genere) {
			
		if (genere == null) {
			return null;
		}
	
		return genere.toString();
	}

	@Override
	public GenereLibro convertToEntityAttribute(String genere) {

		if (genere == null || genere.isBlank()) {
			return null;
		}
		
		return GenereLibro.valueOf(genere.toUpperCase());
	}



}
