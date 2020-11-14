package dS;

import java.util.Arrays;

public class Sort<E extends Comparable<? super E>>{
	
	private E[] arr;
	private QBS<E> search;
	private int len;
	
	public Sort() {
		arr = newArray(100);
		search = new QBS<E>();
		len = 0;
	}
	
	/** Initialize Array */
	public void clear() {
		// fill your code

	 
	}
 
	public void insert(E e) {
		// fill your code
		if (len==0) {
			arr[0]=e;
			len++;
		}
		if (len>0 && len<=10) {
			
		}else
		{
			
		}
		

	} 
	
	public int remove(E e) {
		// fill your code
		

	}
	
	public int find(E e) {
		//fill your code
		int index=-1;
		
		if (len<=10) { //binery search
        		
			
			return index ;
		}
		else 
		{
			return index;
		}
		
	    

	}
	
	public int size() {
		// fill your code
		return len;
	}
	
	public void print() {
		for (int i=0; i<len; i++) {
			System.out.print(arr[i].toString());
			System.out.print(" ");
		}
	}	
	
	static <E> E[] newArray(int length, E... array) {
		return Arrays.copyOf(array, length);
	}
}
