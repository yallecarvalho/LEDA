package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
			
		if (leftIndex >= rightIndex) return;
		else {
			int middle = (leftIndex+rightIndex) /2;
			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
			
		}
	} private void merge (T[] array, int leftIndex, int middle, int rightIndex) {
			T[] aux = Arrays.copyOf(array, array.length);
			//for (int i = leftIndex; i <= rightIndex; i++) {
				//aux[i] = array[i];
			//}
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
