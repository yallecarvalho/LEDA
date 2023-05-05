package produto;

import produto.Produto;

/** Classe que representa um repositorio de produtos usando arrays como estrutura sobrejacente. 
 *  Esse repositorio pode ser utilizado por qualquer tipo de Produto que manipule uma estrutura Array,
 *  sendo assim uma superclasse.
 *
 * @author yallecarvalho
 *
 */

public class RepositorioProdutosArray<T extends Produto> implements RepositorioProdutos<T> {
	
	private T[] produtos;
	private int index = -1;
	
	public RepositorioProdutosArray(int size) {
		super();
		this.produtos =  (T[]) new Object[size];
	}
	
	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int i = 0;
		int resp = -1;
		boolean achou = false;
		while ((i < index) && !achou) {
			if (produtos[i].getCodigo() == codigo) {
				resp = i;
				achou = true;
			}
			i  = i+1;
		} return resp;
	}
	
	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */

	@Override
	public boolean existe(int codigo) {
		boolean existe = false;
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			existe = true;
		}
		return false;
	}
	
	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	@Override
	public void inserir(T produto) {
		produtos[++index] = produto;
		
	}
	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	@Override
	public void atualizar(T produto) {
		int i = this.procurarIndice(produto.getCodigo());
		if (i != -1) {
			produtos[i] = produto;
		}
	}
	
	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	@Override
	public void remover(int codigo) {
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			produtos[i] = produtos[index];
			produtos[index] = null; //remove o objeto que estava nesse indice
			index--; //remove o elemento do array
		} else {
			throw new RuntimeException("Produto inexistente");
		}
	}
	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public T procurar(int codigo) {
		T resp = null;
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			resp = produtos[i];
		
		} else {
			throw new RuntimeException("Produto não encontrado");
		} return resp;
	}
	

}
