package com.sort;



public class InsertionSorter<K extends Comparable<? super K>> {

	/**
	 * Sorts the elements in given array from `left` to `right` in lexicograph order using insertion sort algorithm.
	 */
	
	public void sort(Pair<K, ?>[] array, int left, int right) {
		// Fill your code to sort the elements in `array`.
		for(int i=0;i<array.length-1;i++) {
			for(int j=array.length-1;j>i;j--)
			{
				
				if((array[j].getKey().compareTo(array[j-1].getKey()))<0) {
					Pair<K,?> temp=null;
							temp=array[j-1];
							array[j-1]=array[j];
							array[j]=temp;
				}
					
				     
			}
		}
		
	}
}
	
	// Hint: Maybe you need to create the helper methods.
	
	
