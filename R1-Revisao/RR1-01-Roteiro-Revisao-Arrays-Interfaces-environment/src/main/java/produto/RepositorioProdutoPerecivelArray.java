package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto e Yalle Carvalho - 119210523
 *
 */
public class RepositorioProdutoPerecivelArray extends RepositorioProdutosArray {

	public RepositorioProdutoPerecivelArray(int size) {
		super(size);
	}
	//Método redefinido para inserir somente se o tipo de produto for Produto Perecivel
	@Override
	public void inserir(Produto produto) {
		if(produto instanceof ProdutoPerecivel) {
			super.inserir(produto);
		}
	}
	//Método redefinido para inserir somente se o tipo de produto for Produto Perecivel
	@Override
	public void atualizar (Produto produto) {
		if(produto instanceof ProdutoPerecivel) {
			super.atualizar(produto);
		}
	}

}