package ds.hash;


import java.lang.Comparable;

/** Max-heap implementation */
public class MaxHeap<E extends Comparable<? super E>> {
	private int[] Heap;
	private int size;
	private int maxsize=5;
	
	public boolean isEmpty() {
		return (size==0);
	}
	public MaxHeap () {
		this.size=0;
		Heap=new int[maxsize+1];
		Heap[0]=Integer.MAX_VALUE;
	}
	public void add(int v) {
		//print();
		if(size>maxsize) {
			System.out.println("no more value allowded!\n");
		    return;}
		
		Heap[++size]=v;
		
		int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
        	
            swap(current, parent(current)); 
            current = parent(current); 
        } 
		//print();
	}
	 public void print() 
	    { 
	        for (int i = 0; i <= size ; i++) { 
	            System.out.print(": "+Heap[i]); 
	                       
	            
	        } 
	        System.out.println("\n");
	    } 
	public int removeMax() {
		int max=Heap[1];
		Heap[1]=Heap[--size];
		maxHeapify(1);
		return max;
	}
	public int returnMax() {
		
		return Heap[1];
	}
	
	private void maxHeapify(int pos) {
		if(isLeaf(pos))
			return ;
		if (Heap[pos]<Heap[leftchild(pos)] || Heap[pos]<Heap[rightchild(pos)]) {
			
			if (Heap[leftchild(pos)]>Heap[rightchild(pos)]) {
				swap(pos,leftchild(pos));
				maxHeapify(leftchild(pos));
			}else {
				swap(pos,rightchild(pos));
				maxHeapify(rightchild(pos));
			}
		}
	}
	public int parent(int pos) {
		return pos/2;
	}
	public int leftchild(int pos) {
		return (2*pos);
		
	}
	public int rightchild(int pos) {
		return (2*pos)+1;
	}
	private boolean isLeaf(int pos) {
		return (pos>=(size/2) && pos<=size);
		
	}
	private void swap(int x, int y) {
		int temp=Heap[x];
		Heap[x]=Heap[y];
		Heap[y]=temp;
		
	}
	
	
}
