package br.com.caelum.contas.modelo;

public abstract class Conta {

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

	/**
	 * Método para Remover Valor do Saldo;
	 * 
	 * @param valor
	 */
	public void saca(double valor) {
		this.saldo -= valor;
	}

	/**
	 * Método para Adicionar Valor do Saldo;
	 * 
	 * @param valor
	 */
	public void deposita(double valor) {
		this.saldo += valor;
	}

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
