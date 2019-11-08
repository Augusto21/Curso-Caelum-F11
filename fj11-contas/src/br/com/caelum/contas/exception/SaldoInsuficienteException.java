package br.com.caelum.contas.exception;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = -3295689991828935523L;

	public SaldoInsuficienteException(double valor) {
		super("Saldo insuficiente para sacar o valor de: " + valor);
	}

}
