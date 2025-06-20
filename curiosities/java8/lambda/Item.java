package ilearn.java8.lambda;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;

	/**
	 * Construtor da classe Item.
	 * 
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o produto.
	 *
	 * @return Produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Retorna o valor unitário do item.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * Retorna a quantidade dos item.
	 *
	 * @return int
	 */
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o valor total do item.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		BigDecimal q = new BigDecimal(quantidade);
		
		return valorUnitario.multiply(q).setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Produto: " + produto + " Valor: " + valorUnitario + " Quantidade: " + quantidade;
	}

	// teste Método getValorTotal
	public static void main(String[] args) {
		Item item = new Item(new Produto(new Long(1), "Teste"), new BigDecimal(3.000), 3);

		System.out.println(item);
		System.out.println(item.getValorTotal());

	}
}
