package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {
	
	private boolean verifica(Integer[] array, int leftIndex, int rightIndex) {
		return leftIndex < rightIndex && leftIndex  >= 0 && rightIndex <= array.length -1;
		
	}
	
	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if(verifica(array, leftIndex, rightIndex)) {
			Integer[] novoArray = new Integer[rightIndex - leftIndex + 1];
			int maior = maior(array, leftIndex, rightIndex);
		
			int tamanhoCont;
			boolean zero = zeroIsThere(array, leftIndex, rightIndex);
		
			if (zero) {
				tamanhoCont = maior+1;
			} else {
				tamanhoCont = maior;
			}
		
			int[] cont = new int[tamanhoCont];
		
		
			//Preenche o array de contagem com as frequências dos elementos do array
			for(int i = leftIndex; i < rightIndex+1; i++) {
				if (zero) {
					cont[array[i]] += 1;
				} else {
					cont[array[i]-1] += 1;
				}
			}
		
			//Soma dos elementos no array de contagem
			for (int i = 1; i < cont.length; i++) {
				cont[i] += cont[i-1];
			}
			
			//Registra no novo array os elementos ordenados
			for (int i = rightIndex; i >= leftIndex; i--) {
				if(zero) {
					novoArray[cont[array[i]]-1] = array[i];
					cont[array[i]] -= 1;
			
				} else {
			
					novoArray[cont[array[i]-1]-1] = array[i];
					cont[array[i]-1] -= 1;
				}
	
			}
			//Aloca os elementos do array novo no array original
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = novoArray[i - leftIndex];
			}
	
		}
	}
		


	
	//Procura o maior elemento do array
	private int maior(Integer[] array, int left, int right) {
		int maior = 0;
		for(int i = left; i < right+1; i++) {
			if(array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
			
		} return maior;
	}
	//Checa se tem zero no array
	private boolean zeroIsThere(Integer[] array, int left, int right) {
		
		boolean itIs = false;
		
		for(int i = left; i < right+1; i++)
			if(array[i] == 0) {
				itIs = true;
				
			} return itIs;
	}

}
