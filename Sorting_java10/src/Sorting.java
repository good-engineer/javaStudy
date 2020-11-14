import java.lang.Math;

import java.util.Arrays;

public class Sorting {  
	
    public static void selectionSort(int[] arr){  

    	// TODO
		// Implement selection sort in decreasing order
    	for (int i=0; i<arr.length-1;i++) {
    	   
    		int maxindex=i;
    	   
           for (int j=arr.length-1; j>i;j--) {
        	   if(arr[j] >arr[maxindex])
        		   maxindex=j;
           }
           int temp=arr[i];
           arr[i]=arr[maxindex];
           arr[maxindex]=temp;
    	}

    }
    
    public static void shellSort(int arr[]) { 
    	
    	// TODO
		// Implement shell sort in decreasing order
    	for (int i=arr.length/2;i>=2;i/=2)
    		for(int j=0; j<i; j++)
    			inssort(arr,j,i);
    	inssort(arr,0,1);
    	
    	
    }   
    public static void inssort(int arr[], int start, int incr) {
    	for(int i=start+incr; i<arr.length; i+=incr) {
    		for(int j=i; (j>= start+incr)&& (arr[j]>arr[j-incr]); j-=incr) {
    			 int temp=arr[j];
            arr[j]=arr[j-incr];
            arr[j-incr]=temp;
    		}
    	}
    }
    public static int[] copyArray(int[] arr) {
    	
    	int len = arr.length;
    	int[] arr_cp = new int[len];
		System.arraycopy(arr, 0, arr_cp, 0, len);
    	return arr_cp;
    }
    
    public static void printArray(int[] arr) {
    	for (int i = 0; i<arr.length; i++)
    		System.out.print(arr[i] + " ");
    	System.out.println();
    	System.out.println();
    }
    
    
    public static void initArray(int[] arr, int len) {
    	int randomNumber = 0 , i;
    	for (i = 0; i < len; i++) {
        	randomNumber = (int)Math.round(Math.random()*100);
	    	arr[i] = randomNumber;
    	}
    }
    
        
    public static void main(String [] args) {  
        
    	int len = 60;     //you can change the length of the array
    	int[] arr = new int[len];
    	initArray(arr, len);
    	int[] arr1 = copyArray(arr);
    	int[] arr2 = copyArray(arr);
    	
    	System.out.println("Before Sort:");
        printArray(arr);
       	
        selectionSort(arr1); 
        System.out.println("After Selection Sort:");  
    	printArray(arr1);
        
        shellSort(arr2);
        System.out.println("After Shell Sort:");
    	printArray(arr2);
        
    	if (Arrays.equals(arr1, arr2))
    		System.out.println("Perfect!");
    	else
    		System.out.println("Try Again");

    }  
}  

