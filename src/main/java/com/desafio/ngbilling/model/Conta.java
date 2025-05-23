package com.desafio.ngbilling.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Conta {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private Integer numero_conta;
	
	@Column(nullable = false)
	private Double saldo;

	public Conta(UUID id, Integer numero_conta, Double saldo) {

		this.id = id;
		this.numero_conta = numero_conta;
		this.saldo = saldo;
	}

	public Conta() {

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		return "Conta [id=" + id + ", numero_conta=" + numero_conta + ", saldo=" + saldo + "]";
	}
	
	

}
