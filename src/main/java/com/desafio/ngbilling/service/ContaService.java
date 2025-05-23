package com.desafio.ngbilling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.ngbilling.model.Conta;
import com.desafio.ngbilling.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Conta criarConta(Conta conta) {
		
		return contaRepository.save(conta);
	}
}
