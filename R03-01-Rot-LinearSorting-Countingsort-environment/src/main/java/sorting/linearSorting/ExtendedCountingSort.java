package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	private boolean verifica(Integer[] array, int leftIndex, int rightIndex) {
		return leftIndex < rightIndex && leftIndex  >= 0 && rightIndex <= array.length -1;
		
	}
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (verifica(array, leftIndex, rightIndex)) {
			
		
			Integer[] B = new Integer[rightIndex - leftIndex + 1];
		
			//Checa qual o maior e o menor elemento do array.
			int[] maiorMenor = maiorMenor(array, leftIndex, rightIndex);
			int maior = maiorMenor[0];
			int menor = maiorMenor[1];
			
		
			int[] C = new int[maior - menor + 1];
			
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]- menor] += 1;
			}
		
			for(int i = 1; i < C.length; i++) {
				C[i] += C[i-1];
			}
		
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]- menor] - 1] = array[i];
				C[array[i]- menor] -= 1;
			}
		
			for (int i = leftIndex; i < rightIndex+1; i++) {
				array[i] = B[i];
			}
		

		}
	}
	
	private int[] maiorMenor(Integer[] array, int left, int right) {
		int maior = array[left];
		int menor = array[left];
		for(int i = left; i < right+1; i++) {
			if(array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
			if(array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
			
		} return new int[] {maior, menor};
	}

}
