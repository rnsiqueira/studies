package ilearn.solucoes;

import javax.swing.JLabel;

public class SomaDePontos {
	double pontos;
	double totalPontos;

	public void totalPontos() {

		pontos = 5;
		totalPontos = 9;
		double total = pontos + totalPontos;

		JLabel label = new JLabel(String.valueOf(total));
		System.out.println(label.getText());

	}

	public static void main(String[] args) {
		new SomaDePontos().totalPontos();
	}

}
