package com.desafio.ngbilling.dto;

public class ContaDTO {
	
	private Integer numero_conta;
	private Double saldo;
	
	
	public ContaDTO() {
	}

	public ContaDTO(Integer numero_conta, Double saldo) {
		this.numero_conta = numero_conta;
		this.saldo = saldo;
	}
	
	public Integer getNumero_conta() {
		return numero_conta;
	}
	
	public void setNumero_conta(Integer numero_conta) {
		this.numero_conta = numero_conta;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContaDTO [numero_conta=" + numero_conta + ", saldo=" + saldo + "]";
	}
	
	
	
}
