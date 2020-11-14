package com.sort;

public class QuickSorter<K extends Comparable<? super K>>{
	public void sort(Pair<K, ?>[] array, int left, int right) {
		
		// Fill your code to sort the elements in `array`.
		if(left<right) {
			int p=partition(array,left,right);
			sort(array,left,p-1);
			sort(array,p+1,right);
		}
		
		
	}
	
	// Hint: Maybe you need to create the helper methods.
	int partition (Pair<K,?> [] array,int left,int right) {
		Pair<K,?> pivot=null;
		pivot=array[right];
		int i=left-1;
		for(int j=left;j<right;j++) {
			if(!(array[j].getKey().compareTo(pivot.getKey())>0)) {
				i++;
				Pair<K,?> temp=null;
				temp=array[j];
				array[j]=array[i];
				array[i]=temp;
			}
		}
		
		Pair<K,?> temp=null;
		temp=array[i+1];
		array[i+1]=array[right];
		array[right]=temp;
		return i+1;
	}
	
}
