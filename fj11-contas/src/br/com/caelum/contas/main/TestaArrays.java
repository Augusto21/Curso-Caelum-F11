package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaArrays {

	public static void main(String[] agrs) {
		Conta[] contas = new Conta[10];
		double resultado = 0;

		for (int i = 0; i <= contas.length; i++) {
			Conta conta = new ContaCorrente();
			conta.deposita(i * 100);
			System.out.println("Conta: " + conta + " - " + conta.getSaldo());
			resultado = resultado +conta.getSaldo();
		}
		System.out.println("Média das Contas: " + (resultado / contas.length));
	}
}
