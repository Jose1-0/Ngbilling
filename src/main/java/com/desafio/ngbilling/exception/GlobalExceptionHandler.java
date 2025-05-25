package com.desafio.ngbilling.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.ngbilling.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ContaExeption.class)
	public ResponseEntity<Object> handleContaException(ContaExeption ex) {

        String msg = ex.getMessage();

        HttpStatus status;

        if (msg.contains("não encontrada")) {
            status = HttpStatus.NOT_FOUND;
        } else if (msg.contains("negativo") || msg.contains("existe")) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(new ErrorDTO(msg), status);
    };
    
    @ExceptionHandler(TransacaoException.class)
    public ResponseEntity<String> handleSaldoInsuficiente(TransacaoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}


