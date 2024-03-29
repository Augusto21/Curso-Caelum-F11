package br.com.caelum.contas;

import br.com.caelum.contas.modelo.ContaCorrente;

public class TesteErro {
	
	public static void main(String[] agrs) {
		System.out.println("inicio do main");
		metodo1();
		System.out.println("fim do main");
	}
	
	public static void metodo1() {
		System.out.println("inicio do metodo1");
		metodo2();
		System.out.println("fim do metodo1");
	}
	
	public static void metodo2() {
		System.out.println("inicio do metodo2");
		ContaCorrente cc = new ContaCorrente();
		try {
			for(int i=0; i<=15; i++) {
				cc.deposita(i + 1000);
				System.out.println(cc.getSaldo());
				if(i == 5) {
					cc= null;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("erro: " + e);
		}
		System.out.println("fim do metodo2");
	}
}
