package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		
		int n = array.length;
		
		if (n >= 4) {
			
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		
		} else {
			mergeSort(array, leftIndex, rightIndex);
			MERGESORT_APPLICATIONS++;
		}	
		
	}
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		
		for (int i = leftIndex; i < rightIndex+1; i++) {
			
			int j = i;
			
			while (j > 0 && (array[j].compareTo(array[j-1]) < 0)) {
				Util.swap(array, j, j-1);
				j -= 1;
			}
		}
	}
	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
			
		if (leftIndex >= rightIndex) return;
		else {
			int middle = (leftIndex+rightIndex) /2;
			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
			
		}
	} 
	private void merge (T[] array, int leftIndex, int middle, int rightIndex) {
			T[] aux = Arrays.copyOf(array, array.length);
			for (int i = leftIndex; i <= rightIndex; i++) {
				aux[i] = array[i];
			}
			int inicio = leftIndex;
			int meio = middle + 1;
			int primeiro = leftIndex;
			
			while (inicio <= middle && meio <= rightIndex) {
				
				if (aux[inicio].compareTo(aux[meio]) <= 0) {
					array[primeiro] = aux[inicio++];
				} else {
					array[primeiro] = aux[meio++];
				}primeiro++;
			} 
			while (inicio <= middle) {
				array[primeiro] = aux[inicio];
				inicio++;
				primeiro++;	
			}
			while (meio <= rightIndex) {
				array[primeiro] = aux[meio];
				meio++;
				primeiro++;
		}
    }
}
