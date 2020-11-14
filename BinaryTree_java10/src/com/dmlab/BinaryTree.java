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
				return this.getValue();
			}
			if(compare>0) {
				return this.mRight.find(key);
			}
			if(compare<0) {
				return this.mLeft.find(key);
				
			}
			return null;
		}
		
		/**
		 * Traverse with the preorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the preorder traversal.
		 */
		public String preorder() {
			// TODO: Fill this function
			if (this.mLeft.mLeft!=null) {
				System.out.println(this.mLeft.preorder());
				System.out.println(this.mRight.preorder());
			}
			else {
				System.out.println("[" + this.getKey()+ ":"+this.getValue()+"]");
				System.out.println("[" + this.mLeft.getKey()+ ":"+this.mLeft.getValue()+"]");
				if(this.mRight!=null)
				System.out.println("[" + this.mRight.getKey()+ ":"+this.mRight.getValue()+"]");
			}
			return null;
		}
		
		/**
		 * Traverse with the inorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the inorder traversal.
		 */
		public String inorder() {
			// TODO: Fill this function
			if (this.mLeft.mLeft!=null) {
				System.out.println(this.mLeft.inorder());
				System.out.println(this.mRight.inorder());
			}
			else {
				
				System.out.println("[" + this.mLeft.getKey()+ ":"+this.mLeft.getValue()+"]");
				System.out.println("[" + this.getKey()+ ":"+this.getValue()+"]");
				if(this.mRight!=null)
				System.out.println("[" + this.mRight.getKey()+ ":"+this.mRight.getValue()+"]");
			}
			return null;
			
		}
		
		/**
		 * Traverse with the postorder in this subtree.
		 * @return
		 * 			The String to be printed-out which contains series of nodes as the postorder traversal.
		 */
		public String postorder() {
			// TODO: Fill this function
			if (this.mLeft.mLeft!=null) {
				System.out.println(this.mLeft.postorder());
				System.out.println(this.mRight.postorder());
			}
			else {
				
				System.out.println("[" + this.mLeft.getKey()+ ":"+this.mLeft.getValue()+"]");
				if(this.mRight!=null)
					System.out.println("[" + this.mRight.getKey()+ ":"+this.mRight.getValue()+"]");
				System.out.println("[" + this.getKey()+ ":"+this.getValue()+"]");
				
			}
			return null;
		}
		
		/**
		 * Find the height of this subtree
		 * @return
		 * 			height
		 */
		public int height() {
			// TODO: Fill this function
			int height= 0;
			if (this.mLeft.mLeft!=null) {
				height++;
				 this.mLeft.height();
				 this.mRight.height();
				
			}
			else {
				height=height+2;
				if(this.mRight!=null)
					height++;
			}
			return height;
		}
		
		/**
		 * Delete a node,the key of which match with the key given as param, from this subtree.
		 * You may need to define new method to find minimum of the subtree.
		 * @return
		 * 			the node of which parent needs to point after the deletion.
		 */
		public Node delete(Key key) {
			// TODO: Fill this function
			return null;
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
}
