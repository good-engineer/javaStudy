package com.dmlab;

import com.dmlab.util.EmptyQueueException;
import com.dmlab.util.MyQueue;
import com.dmlab.util.MyStack;

public class StackCalculator {
	
	public StackCalculator() {
		
	}
	
	/**
	 * Solve the given infix form of equation
	 * @param infix
	 * 			the infix form of an equation
	 * 			e.g. 1 + 2 - ( 3 - 4 )
	 * @return
	 * 			the result from the calculation of given equation
	 * @throws EmptyQueueException 
	 */
	public String solve(String infix) throws EmptyQueueException {
		String temp;
		int item1,item2;
		MyStack<String> stack = new MyStack<String>();
        MyQueue<String> queue = new MyQueue<String>();
				String[] split = infix.split(" ");
				
				
				for(int i=0; i<split.length; i++) {
				      if (split[i].equals("+") || split[i].equals("-")) {
				    	  while (!stack.empty() && !stack.peek().equals("(") ) {
				    		  temp=stack.pop();
				    		  queue.add(temp);
				    		  
				    		  
				    	  }
				    	  stack.push(split[i]);  
				      }
				      else if( split[i].equals("(")) {
				    	  stack.push(split[i]);
				      }
				      else if (split[i].equals(")")) {
				    	  while (!stack.peek().equals("(") && !stack.empty() ) {
				    		  
				    			  temp=stack.pop();
				    			  queue.add(temp);  
				    		  
				    	  }
				    	  if(stack.peek().equals("(")) {
				    	      stack.pop(); }
				    	  
				    	 
				      }
				      else    {
				    	  
				    	  
				    	  
				    	  queue.add(split[i]);
				    	  
				      }
				     
					
				}
				
					
				while (!stack.empty()) {
					
					temp=stack.pop();
					
					if(!temp.equals("(")) {
					    queue.add(temp);
					}
					
				}
				
				stack.clear();
				
				while(!queue.empty()) {
				
					temp=queue.poll();
					
					if (temp.equals("+")) {
						item1=Integer.valueOf(stack.pop());
						item2=Integer.valueOf(stack.pop());
						stack.push(String.valueOf(item1+item2));
					}
					if (temp.equals("-")) {
						item1=Integer.valueOf(stack.pop());
						item2=Integer.valueOf(stack.pop());
						stack.push(String.valueOf(item2-item1));
					}
					else if (!temp.equals("+") || !temp.equals("+")) {
						
						stack.push(temp);
					}
				}
				
		return stack.peek();
	}
}
