package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel {

	public String getTipo() {
		return "Conta Corrente";
	}

	@Override
	public void saca(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar " + "um valor negativo");
		} else if (valor > this.saldo) {
			try {
				throw new SaldoInsuficienteException(valor);
			} catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			}

		} else {
			this.saldo -= (valor + 0.10);
		}
	}

	@Override
	public String toString() {
		return "Titular: " + getTitular() + ", Agencia:" + getAgencia() + ", Nº:" + getNumero();
	}

	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.10;
	}
}
