package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exception.SaldoInsuficienteException;

public abstract class Conta implements Comparable<Conta> {

	protected double saldo;

	private String titular;

	private int numero;

	private String agencia;

	public abstract String getTipo();

	public Conta() {

	}

	public Conta(String agencia, int numero, String titular, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int compareTo(Conta outraConta) {

		return this.titular.compareTo(outraConta.titular);
	}

	/**
	 * Método para Remover Valor do Saldo;
	 * 
	 * @param valor
	 */
	public void saca(double valor) {

		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar " + "um valor negativo");
		} else if (valor > this.saldo) {
			try {
				throw new SaldoInsuficienteException(valor);
			} catch (SaldoInsuficienteException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} else {
			this.saldo -= valor;
		}
	}

	/**
	 * Método para Adicionar Valor do Saldo;
	 * 
	 * @param valor
	 */
	public void deposita(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar " + "um valor negativo");
		} else {
			this.saldo += valor;
		}
	}

//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//
//		Conta outraConta = (Conta) obj;
//
//		return this.numero == outraConta.numero && this.agencia == outraConta.agencia;
//	}

	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

}
