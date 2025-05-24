package com.desafio.ngbilling.service.impl;

import com.desafio.ngbilling.exception.TransacaoException;
import com.desafio.ngbilling.model.Conta;
import com.desafio.ngbilling.service.Itransacao;

public class DebitoTransacaoService implements Itransacao{

	@Override
	public void transacao(Conta conta, float valor) {
		float taxa = 0.03f;
		float valorComTaxa = valor + (valor * taxa);
		
		if(conta.getSaldo() < valorComTaxa || conta.getSaldo() == 0) {
			throw new TransacaoException("Saldo insuficiente para transaferencia em Debito");
		}
		
		conta.setSaldo(conta.getSaldo() - valorComTaxa);
	}

}
