package ilearn.java8.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	private List<CarrinhoCompras> carrinhos; 
	
	
	public CarrinhoComprasFactory() {
		carrinhos = new ArrayList<>();
	}

	/**
	 * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
	 *
	 * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho
	 * deverá ser retornado.
	 *
	 * @param identificacaoCliente
	 * @return CarrinhoCompras
	 */
	public CarrinhoCompras criar(String identificacaoCliente, CarrinhoCompras carrinho) {
		for (CarrinhoCompras carrinhoCompras : carrinhos) {
			if (identificacaoCliente.equals(carrinhoCompras.getIdentificacao()))
				return carrinhoCompras;
		}

		if (!carrinhos.contains(carrinho))
			carrinhos.add(carrinho);

		return carrinho;

	}

	/**
	 * Retorna o valor do ticket médio no momento da chamada ao método. O valor do ticket médio é a
	 * soma do valor total de todos os carrinhos de compra dividido pela quantidade de carrinhos de
	 * compra. O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
	 * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTicketMedio() {

		List<Double> doubleValue = new ArrayList<>();
		carrinhos.forEach(c -> doubleValue.add(c.getValorTotal().doubleValue()));

		double soma = doubleValue.stream().mapToDouble(d -> d).sum();
		System.out.println(soma);
		System.out.println(carrinhos.size());
		double media = soma / carrinhos.size();
		System.out.println(media);

		BigDecimal totalBig = new BigDecimal(media);

		return totalBig.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar. Deve
	 * ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos
	 * de compras.
	 *
	 * @param identificacaoCliente
	 * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um
	 *         carrinho de compras e e false caso o cliente não possua um carrinho.
	 */
	public boolean invalidar(String identificacaoCliente) {
		for (CarrinhoCompras carrinhoCompras : carrinhos) {
			if (identificacaoCliente.equals(carrinhoCompras.getIdentificacao()))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CarrinhoCompras c1 = new CarrinhoCompras("Rafael");
		c1.adicionarItem(new Produto(new Long(0), "Feijão"), new BigDecimal(4.97666), 6);
		System.out.println(c1.getItens());
		System.out.println(c1.getValorTotal());

		CarrinhoCompras c2 = new CarrinhoCompras("Siqueira");
		c2.adicionarItem(new Produto(new Long(1), "Arroz"), new BigDecimal(8.97666), 4);
		System.out.println(c2.getItens());
		System.out.println(c2.getValorTotal());
		
		CarrinhoComprasFactory cf = new CarrinhoComprasFactory();
		
		cf.criar(c1.getIdentificacao(), c1);
		cf.criar(c2.getIdentificacao(), c2);
		System.out.println(cf.getValorTicketMedio());

	}

}
