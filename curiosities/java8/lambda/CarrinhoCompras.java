package ilearn.java8.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	private List<Item> itens;
	private Item item;
	private String identificacao;
	

	public CarrinhoCompras(String identificacao) {
		this.identificacao = identificacao;
		itens = new ArrayList<>();
	}
	
	public String getIdentificacao() {
		return identificacao;
	}

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 *
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser
	 * seguidas: - A quantidade do item deverá ser a soma da quantidade atual com a quantidade
	 * passada como parâmetro. - Se o valor unitário informado for diferente do valor unitário atual
	 * do item, o novo valor unitário do item deverá ser o passado como parâmetro.
	 *
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao
	 * carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {

		item = new Item(produto, valorUnitario, quantidade);

		for (Item item1 : itens) {
			if(item1.getProduto().getDescricao().equals(produto.getDescricao())) {
				item1.setQuantidade(item1.getQuantidade() + quantidade);
				item1.setValorUnitario(valorUnitario);
				
			}

		}
		
		if(!itens.contains(item)) itens.add(item);

	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {
		
		for (Item item : itens) {
			if(produto.equals(item.getProduto())) return true;
		}

		return false;

	}

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {

		for (Item item : itens) {

			if (posicaoItem == itens.indexOf(item))
				return true;

		}

		return false;
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		
		List<Double> ldouble = new ArrayList<>();
		
		itens.forEach(i -> ldouble.add(i.getValorTotal().doubleValue()));
		
		double soma = ldouble.stream().mapToDouble(d -> d).sum();
		
		BigDecimal totalBig = new BigDecimal(soma);
		
		return totalBig.setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {

		return itens;
	}

	// testes
	public static void main(String[] args) {
		CarrinhoCompras carrinho = new CarrinhoCompras("Teste");
		carrinho.adicionarItem(new Produto(1L, "Teste"), new BigDecimal(40.00), 4);
		System.out.println(carrinho.getItens());
		System.out.println(carrinho.getValorTotal());

		
	}
}