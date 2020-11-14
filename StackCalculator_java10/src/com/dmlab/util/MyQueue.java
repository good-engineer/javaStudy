package com.dmlab.util;


import java.util.Arrays;

import com.dmlab.interfaces.Queue;


/**
 * Array-based Queue
 * The size of the internal array should be 128
 */
    
public class MyQueue<E> implements Queue<E>{
	private int INITIAL_ARRAY_LENGTH=128;
	@SuppressWarnings("unchecked")
	private E[] array =(E[])new Object[INITIAL_ARRAY_LENGTH];
	private int front=0;
	private int rear=-1;
	int size=0;  
	
	public MyQueue() {
		this.front=0;
		this.rear=-1;
		this.size=0;
	
	}

	@Override
	public void clear() {
		Arrays.fill(array, null);
		this.front=0;
		this.rear=-1;
		this.size=0;
	}

	@Override
	public void add(E item) throws RuntimeException {
		
			rear++;
			
			if(rear==127) {
				rear=0;
			}
            array[rear]=item;
			size++;
			
		
	}

	@Override
	public E poll() throws EmptyQueueException {
	          
				front++;
				if(front==127) {
					this.front=0;
					size--;
					return array[126];
					
				}else {
					size--;
					
					
					return array[front-1];
				}
			
	}

	@Override
	public E peek() throws EmptyQueueException {
		
		return array[front];
	}

	@Override
	public boolean empty() {
		if(this.size==0)
		    return true;
		else 
			return false;
	}
	

}
