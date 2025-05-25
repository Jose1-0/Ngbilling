package com.desafio.ngbilling.service.impl;

import org.springframework.stereotype.Service;

import com.desafio.ngbilling.exception.TransacaoException;
import com.desafio.ngbilling.model.Conta;
import com.desafio.ngbilling.service.Itransacao;

@Service("C")
public class CreditoTransacao implements Itransacao{

	@Override
	public void transacao(Conta conta, float valor) {
		float taxa = 0.05f;
        float valorComTaxa = valor * (1 + taxa);
		
		if (conta.getSaldo() < valorComTaxa) {
            throw new TransacaoException("Saldo insuficiente para transação Crédito");
        }
        conta.setSaldo(conta.getSaldo() - valorComTaxa);
    }

}
