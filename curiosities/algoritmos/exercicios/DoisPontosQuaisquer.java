package ilearn.algoritmos.exercicios;

import java.math.BigDecimal;

/*
 * 1. Construa um algoritmo que, tendo como dados de entrada dois pontos quaisquer
 * no plano, P(x1,y1) e P(x2,y2), escreva a distância entre eles. A fomula que efetua tal calcúlo:
 */
public class DoisPontosQuaisquer {
	


	

	private double p1_x;
	private double p1_y;
	private double p2_x;
	private double p2_y;

	public DoisPontosQuaisquer(double P1_x, double P1_y, double P2_x, double P2_y) {
		p1_x = P1_x;
		p1_y = P1_y;
		p2_x = P2_x;
		p2_y = P2_y;

	
	}
	

	
	
	public BigDecimal CalculoD() {
		double a = p2_x - p1_x ;
		double e1 = Math.pow(a, 2);
		double b = p2_y - p1_y;
		double e2 = Math.pow(b, 2);
		double s = e1 + e2;
		BigDecimal result = new BigDecimal(Math.sqrt(s));
		
		
		return result.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}
		
	public static void main(String[] args) {
		System.out.println(new DoisPontosQuaisquer(1, 2, 5, 3).CalculoD());
	}
}
