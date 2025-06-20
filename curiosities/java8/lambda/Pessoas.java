package ilearn.java8.lambda;

public class Pessoas {
	
	private String nome;
	private int idade;
	private double valorConta;

	public Pessoas(String nome, int idade, double valorConta) {
		this.nome = nome;
		this.idade = idade;
		this.valorConta = valorConta;
		
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getValorConta() {
		return valorConta;
	}
	
	

}
