package com.dmlab;

public class BinaryTree<Key extends Comparable<? super Key>, E> {
	
	class Node {
		private Key mKey;
		private E mValue;
		
		private Node mLeft;
		private Node mRight;
		
		public Node(Key key, E value) {
			mKey = key;
			mValue = value;
			mLeft = null;
			mRight = null;
		}

		public Key getKey() {
			return mKey;
		}

		public E getValue() {
			return mValue;
		}
		
		/**
		 * Insert a node to the subtree, the root of which is this node.
		 * If the subtree already has node with the given key in the param,
		 * 		replace the value of the node in the subtree.
		 * Please compare keys using compareTo method.
		 * e.g. when "int compare = KEY0.compareTo(KEY1)"
		 * 		if compare == 0, this means KEY0 is equal to KEY1
		 * 		if compare > 0, KEY0 > KEY1
		 * 		if compare < 0, KEY0 < KEY1
		 * @param key
		 * @param value
		 * @return
		 * 			None
		 */
		public void insert(Key key, E value) {
			// TODO: Fill this function
			int compare= key.compareTo(this.getKey());
			if(compare==0) {
				this.mKey=key;
				this.mValue=value;
			}
			if(compare>0) {
				this.mRight.insert(key, value);
				}
			else if(compare<0)
				this.mLeft.insert(key, value);
				
			
			
		}

		/**
		 * Find the value of item by the key in the subtree, the root of which is this node.
		 * @param key
		 * @return
		 * 			the value of item matched with the given key.
		 * 			null, if there is no matching node in this subtree.
		 */
		public E find(Key key) {
			// TODO: Fill this function
			int compare=key.compareTo(this.getKey());
			if(compare==0) {
				
				return (E) this;
			}
			if(compare>0) {
				return this.mRight.find(key);
			}
			if(compare<0) {
				return this.mLeft.find(key);
				
			}
			else
			   return null;
			
		}

		@Override
		public String toString() {
			return "[" + String.valueOf(mKey) + ":" + String.valueOf(mValue) + "]";
		}
		
		/**
		 * Traverse with the preorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the preorder traversal.
		 */
		public String preorder() {
			// TODO: Fill this function
			String n= this.toString();
			this.mLeft.preorder();
			this.mRight.preorder();
			return n;
		}
		
		/**
		 * Traverse with the inorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the inorder traversal.
		 */
		public String inorder() {
			// TODO: Fill this function
			
			this.inorder();
			String n= this.mLeft.toString();
			this.mRight.inorder();
			return n;
			
		}
		
		/**
		 * Traverse with the postorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the postorder traversal.
		 */
		public String postorder() {
			// TODO: Fill this function
			this.mLeft.postorder();
			this.mRight.postorder();
			String n= this.toString();
			
			return n;
		}
		
		/**
		 * Find the height of this subtree
		 * @return
		 * 			height
		 */
		public int height() {
			// TODO: Fill this function
			int hl=0;
			int hr=0;
			if(this.mLeft!=null  ) {
				hl=this.mLeft.height();
			}
			if (this.mRight!=null) {
			    hr=this.mRight.height();
			}
			if(hl>hr)
				return 1+hl;
			else
				return 1+hr;
		}
		
		public Node findMin() {
			if (mLeft == null)
				return this;
			else
				return mLeft.findMin();
		}
		
		/**
		 * Delete a node,the key of which match with the key given as param, from this subtree.
		 * You may need to define new method to find minimum of the subtree.
		 * @return
		 * 			the node of which parent needs to point after the deletion.
		 */
		public Node delete(Key key) {
			// TODO: Fill this function
			int compare=key.compareTo(this.getKey());
			if (compare==0) {
				if(this.mLeft!=null && this.mRight!=null) {
                       Node n=mRight.findMin();
                       mKey=n.getKey();
                       mValue=n.getValue();
                       mRight=n.delete(mKey);
                       return this;
				
				}
				else if(mLeft!=null) {
					return mLeft;
				}
				else 
					return mRight;
			}
			if(compare>0) {
				if(mLeft !=null)
			           mLeft=mLeft.delete(key);
				return this;
			}
			else {
				if (mRight!=null) {
					mRight=mRight.delete(key);
				
				}
				return this;
			}
			
		}
		
		
		/**
		 * Given a tree rt, key k1 and key k2, 
		 * find the lowest commen ancestor of k1 and k2 in tree rt.
		 * @param rt is the root of the tree
		 * @param k1 is the first key
		 * @param k2 is the second key
		 * @return the lowest commen ancestor node, if exists.
		 */
		public Node lowestCommonAncestor(Node rt, Key k1, Key k2) {
			// TODO: Fill this function
		    
		   if(rt==null) {
			   return null;
		   }
		   if (k1.compareTo(rt.mKey) <0 && k2.compareTo(rt.mKey)<0) {
			   return lowestCommonAncestor(rt.mLeft, k1 , k2);
			   
		   }
		   if (k1.compareTo(rt.mKey) >0 && k2.compareTo(rt.mKey)>0) {
			   return lowestCommonAncestor(rt.mRight, k1 , k2);
		   }   
		   else
			   return rt;
		
		}
	}
	
	private Node mRoot;
	public BinaryTree() {
		mRoot = null;
	}
	
	public void insert(Key key, E value) {
		if (mRoot == null) {
			mRoot = new Node(key, value);
		} else {
			mRoot.insert(key, value);
		}
	}
	
	public void delete(Key key) {
		if (mRoot == null)
			return;
		mRoot = mRoot.delete(key);
	}
	
	public E find(Key key) {
		if (mRoot == null)
			return null;
		return mRoot.find(key);
	}
	
	public void preorder() {
		System.out.print("preorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.preorder());
	}
	
	public void inorder() {
		System.out.print("inorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.inorder());
		
	}
	
	public void postorder() {
		System.out.print("postorder : ");
		if (mRoot == null) {
			System.out.println("None");
			return;
		}
		System.out.println(mRoot.postorder());
	}
	
	public int height() {
		if (mRoot == null)
			return 0;
		return mRoot.height();
	}
	
	public void lowestCommonAncestor(Key k1, Key k2) {
		if (mRoot == null)
			System.out.println("The tree is empty");
		else if (k1 == null || k2 == null) {
			System.out.println("Error, the key is null");
		} else if (mRoot.find(k1) != null && mRoot.find(k2) != null) {
			Node n = mRoot.lowestCommonAncestor(mRoot, k1, k2);
			System.out.println("LCA of "+k1+" and "+k2+" : ["+n.getKey()+":"+n.getValue()+"]");
		}
		else {
			System.out.println("The key doesnt exist");
		}
	}
}
