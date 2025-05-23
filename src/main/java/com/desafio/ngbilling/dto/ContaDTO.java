package com.desafio.ngbilling.dto;

public class ContaDTO {
	
	private Integer numeroConta;
	private float saldo;
	
	
	public ContaDTO() {
	}

	public ContaDTO(Integer numeroConta, float saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public Integer getNumero_conta() {
		return numeroConta;
	}
	
	public void setNumero_conta(Integer numero_conta) {
		this.numeroConta = numero_conta;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContaDTO [numero_conta=" + numeroConta + ", saldo=" + saldo + "]";
	}
	
	
	
}
