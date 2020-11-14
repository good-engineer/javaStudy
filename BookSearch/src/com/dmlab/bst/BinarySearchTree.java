package com.dmlab.bst;



public class BinarySearchTree<Key extends Comparable<? super Key>, E> {
	
	/** root of this tree */
	private BinaryNode<Key, E> root;
	private int nodecount = 0;
	// Declare more variables HERE

	/** 
	 * Constructor 
	 * Do not modify this function.
	 */
	public BinarySearchTree() {
		root = null;
		nodecount = 0;
	}

	/**
	 * This function returns the root of the BST.
	 * Do not modify this function.
	 * @return
	 */
	public BinaryNode<Key, E> getRoot() {
		return root;
	}

	/** 
	 * Reinitialize tree 
	 */
	public void clear() {
		root = null;
		nodecount = 0;
	}

	/** 
	 * Insert an item into the tree.
	 * @param key of the item
	 * @param value of the item
	 */
	public void insert(Key key, E v) {
		// TODO: Fill in this function
		
		if (root == null) {
			
			root = new BinaryNode<Key, E>(key, v);
			nodecount++;
			
		} else {
			
			BinaryNode<Key, E> rt=new BinaryNode<Key, E>();
			rt=insertHelp(root,key,v);
			
			int compare= key.compareTo( rt.getKey());
					
			
			if(compare>0) {
				
				rt.setRight(new BinaryNode<Key, E>(key,v));
				rt.getRight().setParent(rt);
				this.nodecount++;
				
					
				}
			else  {
				
				rt.setLeft(new BinaryNode<Key, E>(key,v));
				rt.getLeft().setParent(rt);
				this.nodecount++;
				
								
	       }
	
	}
	}	

	/** 
	 * Remove an item from the tree. 
	 * @param key of the item to be removed.
	 * @return the value of the removed item. If no such item, return null.
	 */
	public E remove(Key key) {
		// TODO: Fill in this function
		E tmp = findHelp(root, key);
		root=removeHelp(root,key);
		this.nodecount--;
			return tmp;
	}

	/**
	 * Find the item with key=k.
	 * @param k
	 * @return the value if the item. If no such item, return null.
	 * Do not modify this function.
	 */
	public E find(Key k) {
		return findHelp(root, k);
	}

	/** 
	 * @return The number of nodes in the tree. 
	 */
	public int size() {
		return nodecount;
	}

	/**
	 * Find the item with key=i in the tree rt.
	 * @param rt is the root of the tree.
	 * @param k is the key that we want to find in tree rt.
	 * @return the value of the wanted item. If no such item, return null.
	 */
	private E findHelp(BinaryNode<Key, E> rt, Key k) {
		// TODO: Fill in this function
		if (rt==null)
			return null;
		
		int compare=k.compareTo((Key)rt.getKey());
				
	    if(compare==0) {
		    return rt.getValue();
		}
		if(compare>0) {
			
			if (rt.getRight()!=null)
			 return findHelp(rt.getRight(),k);
			else return null;	
			}
		if(compare<0) {
			
			if (rt.getLeft()!=null)
			return findHelp(rt.getLeft(),k);
			else return null;				
       }
		else 
			return null;
		
		
	}

	/**
	 * This function print the tree of "root" in inorder.
	 * Do not modify this function.
	 */
	public void inorder() {
		inorderHelper(root);
	}

	
	/**
	 * Given a tree with root rt, print the keys of all its nodes in inorder.
	 * Each line for each node. 
	 * Output specification is "ORDER: key".
	 * @param rt is the root of the tree
	 */
	private void inorderHelper(BinaryNode<Key, E> rt) {
		// TODO: Fill in this function
		if (rt==null)
			return;
		
        inorderHelper(rt.getLeft());        
        System.out.println("ORDER: "+rt.getKey().toString());
	    inorderHelper(rt.getRight());
		
	}

	/**
	 * Given range [from, to], count how many nodes are in this range.
	 * @param from is the lower bound of the range
	 * @param to is the upper bound of the range
	 * @return the number of nodes in this range
	 * Do not modify this function.
	 */
	public int rangeSearch(Key from, Key to) {
		return rangeSearchHelper(root, from, to);
	}

	/**
	 * Given range [from, to] and a tree rt, count how many nodes are in this range.
	 * @param rt is the root of the tree
	 * @param from is the lower bound of the range
	 * @param to is the upper bound of the range
	 * @return the number of nodes in this range
	 */
	private int rangeSearchHelper(BinaryNode<Key, E> rt, Key from, Key to) {
		// TODO: Fill in this function
		int compare1=from.compareTo( rt.getKey());
		int compare2=to.compareTo(rt.getKey());
		if (compare1<0) {
			 return 1+rangeSearchHelper(rt.getLeft(),from,to);
		}
		if (compare1<=0 && compare2>=0)
			return 1;
		if(compare2>0) {
			return 1+rangeSearchHelper(rt.getRight(),from,to);
		}
		else
		    return -1;
	}

	/**
	 * Insert the item <key,v> into the tree rt.
	 * @return the tree after insertion
	 */
	private BinaryNode<Key, E> insertHelp(BinaryNode<Key, E> rt, Key key, E v) {
		// TODO: Fill in this function
		
		int compare= key.compareTo( rt.getKey());
		
		if (!rt.isLeaf()) {
			
			if(compare>0) {
				
				
				if (rt.getRight()!=null)
				   return insertHelp(rt.getRight(),key,v);
				else return rt;
				}
			else {
				
				if (rt.getLeft()!=null)
				 return insertHelp(rt.getLeft(),key,v);
				else return rt;
								
		    }
			
		
	      }
		
		return rt;
	}

	/**
	 * Remove a node with key value k from the tree rt.
	 * @return the tree after removing.
	 */
	private BinaryNode<Key, E> removeHelp(BinaryNode<Key, E> rt, Key k) {
		// TODO: Fill in this function
		if (rt==null) {
			
			return null;
		}
		
		int compare= k.compareTo( rt.getKey());
		
		
		if(compare>0) {
			
			rt.setRight(removeHelp(rt.getRight(),k));				
			}
		if(compare<0) {
			
			rt.setLeft(removeHelp(rt.getLeft(),k));
							
	        }
		else if (compare==0) {
			
			if (rt.getLeft()==null && rt.getRight()==null) {
	 			rt=null;
				return null;
			}
			if (rt.getLeft()!=null && rt.getRight()!=null) {
			BinaryNode<Key,E> min=new BinaryNode<Key,E>();
			min=deleteMin(rt.getRight());
			rt.setKey(min.getKey());
			rt.setRight(removeHelp(rt.getRight(), min.getKey()));
			
			
			}
			else if(rt.getLeft()==null) {
				return rt.getRight();
			}else 
				return rt.getLeft();
		}
		
		return rt;
	}

	/**
	 * Given a tree rt, get its smallest node. 
	 * The smallest node is the node with the minimum key.
	 * @param rt
	 * @return the smallest node. 
	 */
	private BinaryNode<Key, E> getMin(BinaryNode<Key, E> rt) {
		// TODO: Fill in this function
		if (rt==null)
			return null;
		
		
		while(rt.getLeft()!=null) {
			rt=rt.getLeft();
		}
			return rt;
		
		
	}

	/**
	 * Given a tree rt, delete the smallest node and return this tree.
	 * @param rt
	 * @return the tree after deletion.
	 */
	private BinaryNode<Key, E> deleteMin(BinaryNode<Key, E> rt) {
		// TODO: Fill in this function
		
		if(rt.getLeft()!=null)
			return deleteMin(rt.getLeft());
		if (rt.getRight()==null)
			rt.getParent().setLeft(null);
		else
			if(rt.getRight()!=null)
		    	rt.getParent().setLeft(deleteMin(rt.getRight()));
		return rt;
	}

	/**
	 * Get the key of the smallest node.
	 * Do not modify this function
	 * @return
	 */
	public Key getFirst() {
		return getFirst(root);
		
	}

	/**
	 * Given a tree rt, get the key of the smallest node.
	 * @param rt
	 * @return the key of the smallest node. If the tree is empty, return null.
	 */
	private Key getFirst(BinaryNode<Key, E> rt) {
		// TODO: Fill in this function
		if (rt==null) 
			return null;
		else 
			return getMin(rt).getKey();
	}

	/**
	 * Get the key of the biggest node.
	 * The biggest node is the node with maximum key.
	 * Do not modify this function.
	 * @return
	 */
	public Key getLast() {
		return getLast(root);
	}

	/**
	 * Given a tree rt, get the key of the biggest node.
	 * @param rt
	 * @return the key of the biggest node. If the tree is empty, return null.
	 */
	private Key getLast(BinaryNode<Key, E> rt) {
		// TODO: Fill in this function
		if (rt==null)
			return null;
	
		
		while(rt.getRight()!=null) {
			rt=rt.getRight();
		}
		
			return rt.getKey() ;
		
		
	}

	// Implement more functions HERE
}
