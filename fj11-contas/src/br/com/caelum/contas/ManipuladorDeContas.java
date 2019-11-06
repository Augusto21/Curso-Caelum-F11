package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {

	private Conta conta;

	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca();
		}
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));
		this.conta.setTitular(evento.getString("titular"));
	}

	public void deposita(Evento evento) {
		this.conta.deposita(evento.getDouble("valorOperacao"));
	}

	public void saca(Evento evento) {
		double valor = evento.getDouble("valorOperacao");
		if (this.conta.getTipo().equals("Conta Corrente")) {
			this.conta.saca(valor + 0.10);
		} else {
			this.conta.saca(valor);
		}
	}

	public void transfere(Evento evento) {
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		this.conta.transfere(evento.getDouble("valorTransferencia"), destino);
	}
}
