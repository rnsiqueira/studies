package ilearn.algoritmos.exercicios;
/*
 * Escreva um algoritmo que leia três numero inteiros e positivos (A, B, C) e calcule a seguinte :
 */

import java.math.BigDecimal;

public class TresNumeroInteiro {
	private int a;
	private int b;
	private int c;

	public void A(int a) throws Exception {
		if (a < 0)
			throw new Exception("variavel aceita apenas numeros inteiros e positivos!");
		this.a = a;

	}

	public void B(int b) throws Exception {
		if (b < 0)
			throw new Exception("variavel aceita apenas numeros inteiros e positivos!");
		this.b = b;

	}

	public void C(int c) throws Exception {
		if (c < 0)
			throw new Exception("variavel aceita apenas numeros inteiros e positivos!");

		this.c = c;

	}
	
	public BigDecimal CalculoD() {
		double R = Math.pow(a+b, 2);
		System.out.println(R);
		double S = Math.pow(b+c, 2);
		System.out.println(S);
		BigDecimal D = new BigDecimal((R+S)/2);
		System.out.println(D);
		
		return D.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
	}
	
	public static void main(String[] args) throws Exception {
		TresNumeroInteiro D = new TresNumeroInteiro();
		
		D.A(9);
		D.B(6);
		D.C(9);
		
		System.out.println(D.CalculoD());
	}

}
