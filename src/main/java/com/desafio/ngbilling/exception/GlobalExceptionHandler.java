package com.desafio.ngbilling.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {
	
	@ExceptionHandler(ContaExeption.class)
	public ResponseEntity<Object> handleContaException(ContaExeption ex){
		
		Map<String, String> response = new HashMap<>();
		response.put("erro: ", ex.getMessage());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
