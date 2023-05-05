package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		int left = 0;
		int right = array.length-1;

	
		if (array != null && array.length > 0 && x != null) {
			quickSort(array, left, right);
			return binarySearchfloor(array, x, null, left, right);
			
		}
			
		return null;
		
	}
	private Integer binarySearchfloor(Integer[] array, Integer x, Integer floor, int left, int right) {
		

			if (array != null && left >= 0 && left <= right && right < array.length) {
				int mid = (left+right)/2;
				
				if(array[mid].compareTo(x) == 0) {
					return array[mid];
				} else if (array[mid].compareTo(x) > 0) {
					return binarySearchfloor(array, x, floor, left, mid-1);
				} else if (array[mid].compareTo(x) < 0) {
					return binarySearchfloor(array, x, array[mid], mid+1, right);
				}
				
			}
			return floor;
				
		
	}
	
	
	private void quickSort(Integer[] array, int left, int right) {
		
		if(array != null & left >= 0  && left < right && right < array.length) {
			int index_pivot = partition(array, left, right);
			quickSort(array, left, index_pivot-1);
			quickSort(array, index_pivot+1, right);
		}

	}
	
	private int partition(Integer[] array, int left, int right) {
		
		int pivot = array[left]; 
		int i = left; 
		
		for(int j = left+1; j < right; j++) {
			if (array[j].compareTo(pivot) <= 0) { 
				i++;
				Util.swap(array, i, j); 
			}
			
		} Util.swap(array, left, i);	
		return i; 
		
	} 
}
