package com.desafio.ngbilling.service.impl;

import com.desafio.ngbilling.model.Conta;

public interface Itransacao {
	
	public void transacao(Conta conta, float valor);
}
