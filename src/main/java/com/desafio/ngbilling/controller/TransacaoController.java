package com.desafio.ngbilling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.ngbilling.dto.ContaDTO;
import com.desafio.ngbilling.dto.TransacaoDTO;
import com.desafio.ngbilling.exception.TransacaoException;
import com.desafio.ngbilling.model.Conta;
import com.desafio.ngbilling.service.impl.TransacaoService;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<?> realizarTransacao(@RequestBody TransacaoDTO dto){
		
		try {
			Conta conta = transacaoService.realizarTransacao(dto);
			ContaDTO contaDTO = new ContaDTO(conta.getNumeroConta(), conta.getSaldo());
			return ResponseEntity.status(201).body(contaDTO);
		} catch (TransacaoException e) {
            return ResponseEntity.status(404).body("Saldo insuficiente para realizar a transação.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Forma de pagamento inválida.");
        }
	}
}
