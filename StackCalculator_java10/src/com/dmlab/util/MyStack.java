package com.dmlab.util;

import java.util.Arrays;
import java.util.EmptyStackException;

import com.dmlab.interfaces.Stack;

/**
 * Array-based Stack
 * The size of the internal array should be 128
 */
public class MyStack<E> implements Stack<E> {
	private int INITIAL_ARRAY_LENGTH=128;
	@SuppressWarnings("unchecked")
	private E[] arr =(E[])new Object[INITIAL_ARRAY_LENGTH];
	private int top=-1;
	private int size =0;
	
	
	
	public MyStack() {
		
		this.top=-1;
		this.size=0;
	}

	@Override
	public void clear() {
		Arrays.fill(arr, null);
		this.top=-1;
		this.size=0;
	}

	@Override
	public void push(E item) throws RuntimeException {
		arr[size]=item;
		size++;
		top++;
		
		
	}

	@Override
	public E pop() throws EmptyStackException {
		E item=arr[top];
		arr[top]=null;
		size--;
		top--;
		
		return item;
	}

	@Override
	public E peek() throws EmptyStackException {
		
		
		return arr[top];
	}

	@Override
	public boolean empty() {
		if(size==0)
     		return true;
		else 
			return false;
	}

}
