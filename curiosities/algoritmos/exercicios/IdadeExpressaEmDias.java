package ilearn.algoritmos.exercicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IdadeExpressaEmDias{
	int dia;
	int mes;
	int ano;

	/*
	 * Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e
	 * dias e mostre-a expressao apenas em dias.
	 */

	public String idade(String idade) {
		dia = Integer.parseInt(idade.substring(0, 2));
		mes = Integer.parseInt(idade.substring(3, 5));
		ano = Integer.parseInt(idade.substring(6, 10));

		return idade;
	}

	private int diasExpresso() {
		int mes = this.mes * 30;
		int ano = this.ano * 365;
		int result = dia + mes + ano;

		return result;
	}
	
	private int dataAtual() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtual = formatDate.format(Calendar.getInstance().getTime());
		
		int diaAtual = Integer.parseInt(dataAtual.substring(0, 2));
		System.out.println(diaAtual);
		int mesAtual = Integer.parseInt(dataAtual.substring(3, 5));
		System.out.println(mesAtual);
		int anoAtual = Integer.parseInt(dataAtual.substring(6, 10));
		System.out.println(anoAtual);
		int resultAtual = diaAtual + (mesAtual*30) + (anoAtual*365);
		return resultAtual;
	}
	
	public int idadeExpressaEmDias() {
		return dataAtual() - diasExpresso();
	}

	public static void main(String[] args) {
		IdadeExpressaEmDias adulto = new IdadeExpressaEmDias();

		adulto.idade("16/01/2018");
		System.out.println(adulto.dia);
		
		System.out.println(adulto.diasExpresso());
		System.out.println(adulto.dataAtual());
		System.out.println(adulto.idadeExpressaEmDias());
		
		
		
		
		
		
	}

}
