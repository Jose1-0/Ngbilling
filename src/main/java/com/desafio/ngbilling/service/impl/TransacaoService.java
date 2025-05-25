package com.desafio.ngbilling.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.ngbilling.dto.TransacaoDTO;
import com.desafio.ngbilling.exception.ContaExeption;
import com.desafio.ngbilling.exception.TransacaoException;
import com.desafio.ngbilling.model.Conta;
import com.desafio.ngbilling.model.Transacao;
import com.desafio.ngbilling.repository.ContaRepository;
import com.desafio.ngbilling.repository.TransacaoRepository;
import com.desafio.ngbilling.service.Itransacao;

import jakarta.transaction.Transactional;

@Service
public class TransacaoService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private Map<String, Itransacao> transacaoMap;

	@Transactional
	public Conta realizarTransacao(TransacaoDTO dto) {

		Conta conta = contaRepository.findByNumeroConta(dto.getNumeroConta())
				.orElseThrow(() -> new ContaExeption("conta não encontrada"));

		Itransacao transacaoService = transacaoMap.get(dto.getFormaPagamento());
		if (transacaoService == null) {
			throw new TransacaoException("Forma de pagamento inválida");
		}

		transacaoService.transacao(conta, dto.getValor());

		contaRepository.save(conta);

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setFormaPagamento(dto.getFormaPagamento());
		transacao.setValor(dto.getValor());
		transacaoRepository.save(transacao);

		return conta;
	}

}
