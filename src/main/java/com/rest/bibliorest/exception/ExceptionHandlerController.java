package com.rest.bibliorest.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> handleEntityNotFoundException(EntityNotFoundException ex) {

		Map<String, String> mappaErrori = new HashMap<String, String>();
		mappaErrori.put("messaggio", ex.getMessage());

		return mappaErrori;
	}
	
	@ExceptionHandler(DataConflicException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Map<String, String> handleDataConflicException(DataConflicException ex) {

		Map<String, String> mappaErrori = new HashMap<String, String>();
		mappaErrori.put("messaggio", ex.getMessage());

		return mappaErrori;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, String> mappaErrori = new HashMap<String, String>();

		ex.getBindingResult().getFieldErrors().forEach(e -> mappaErrori.put(e.getField(), e.getDefaultMessage()));

		return mappaErrori;
	}
}
