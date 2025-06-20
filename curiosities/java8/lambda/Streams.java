package ilearn.java8.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

	public BigDecimal toDouble(double valor) {
		return new BigDecimal(valor);
	}

	public static void main(String[] args) {
		Streams valuesBig = new Streams();

		List<BigDecimal> values = Arrays.asList(valuesBig.toDouble(90.009), valuesBig.toDouble(490.00988),
				valuesBig.toDouble(44455590.00988888));

		values.forEach(i -> System.out.println(i.setScale(3, BigDecimal.ROUND_HALF_EVEN)));

		BigDecimal valor1;
		BigDecimal valor2;
		BigDecimal valor3;
		BigDecimal valor4;
		BigDecimal resultados;

		valor1 = valuesBig.toDouble(6087.7866666);
		valor2 = valuesBig.toDouble(45.09);
		valor3 = valuesBig.toDouble(865.67888);
		valor4 = valuesBig.toDouble(7.09);

		resultados = valor2.add(valor4).subtract(valor2).multiply(valor3).add(valor1);

		System.out.println("Equação sobre BigDecimal: " + resultados.setScale(3, BigDecimal.ROUND_HALF_EVEN));

		List<Pessoas> listPessoas = Arrays.asList(new Pessoas("Rafael N. Siqueira", 28, 10600000.00),
				new Pessoas("João", 60, 30000.00), new Pessoas("Guilherme", 19, 560.00),
				new Pessoas("Lucas", 23, 9000.00), new Pessoas("Renan", 28, 800460.00),
				new Pessoas("Evandro", 55, 205550.00), new Pessoas("Ingrid", 17, 350.00),
				new Pessoas("Mariana", 32, 50000.00), new Pessoas("Vinicius", 22, 36000.00));

		System.out.println("=================================================================================");

		Stream<Pessoas> stremsPessoas = listPessoas.stream();

		/*
		 * int somaIdades = stremsPessoas.mapToInt(p -> p.getIdade()).sum();
		 * System.out.println("Soma Idade da Lista : " + somaIdades);
		 */

		/*
		 * OptionalDouble media = stremsPessoas.mapToDouble(p ->
		 * p.getIdade()).average();
		 * 
		 * System.out.println("M�dia de idade referente a Lista: " + media);
		 * 
		 */
		
		DoubleSummaryStatistics statistics = stremsPessoas.mapToDouble(p -> p.getValorConta()).summaryStatistics();
		BigDecimal bgMax = new BigDecimal(statistics.getMax());
		BigDecimal bgSum = new BigDecimal(statistics.getSum());
		System.out.println("Media da Lista: " + statistics.getAverage());
		System.out.println("Total de contas na Lista: " + statistics.getCount());
		System.out.println("Conta com Valor Maior: " + bgMax.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		System.out.println("Conta com Valor Menos: " + statistics.getMin());
		System.out.println("Soma da Agencia: " + bgSum.setScale(3, BigDecimal.ROUND_HALF_EVEN));
		System.out.println("Geral: " + statistics.toString());
		
		
		
		
		
		
		
	}

}
