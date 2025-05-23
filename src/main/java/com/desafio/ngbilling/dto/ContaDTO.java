package com.desafio.ngbilling.dto;

public class ContaDTO {
	
	private Integer numero_conta;
	private float saldo;
	
	
	public ContaDTO() {
	}

	public ContaDTO(Integer numero_conta, float saldo) {
		this.numero_conta = numero_conta;
		this.saldo = saldo;
	}
	
	public Integer getNumero_conta() {
		return numero_conta;
	}
	
	public void setNumero_conta(Integer numero_conta) {
		this.numero_conta = numero_conta;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContaDTO [numero_conta=" + numero_conta + ", saldo=" + saldo + "]";
	}
	
	
	
}
