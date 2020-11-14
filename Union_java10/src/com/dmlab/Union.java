package com.dmlab;

public class Union {
	
	int[] mID = new int[10];
	int size=1;
	/**
	 * Constructor of this class
	 * If you have something to initialize, implement in here.
	 */
	Union() {
		for(int i=0;i<10;i++) {
			mID[i]=-1;
			
		}
		/**
		 * Initialize mID field to be belonged in the different set.
		 */
	}
	
	/**
	 * Union two set where node1 and node2 is belong.
	 * Do nothing if node1 and node2 are in the same set.
	 * When union two set, you should follow the "weighted rule".
	 * @param node1, node2
	 * 			node numbers
	 * @return
	 */
	void unionWU(int node1, int node2) {
		int root1=find(node1);
		int root2=find(node2);
		
		if(root1!=root2) {
			int weight1=groupSize(node1);
			int weight2=groupSize(node2);
			if(weight1>weight2) {
				mID[root2]=mID[root1];
			}
			else {
				mID[root1]=mID[root2];
			}
		}
		
	
	}

	/**
	 * Union two set where node1 and node2 is belong.
	 * Do nothing if node1 and node2 are in the same set.
	 * When union two set, you should follow the "depth rule".
	 * @param node1, node2
	 * 			node numbers
	 * @return
	 */
	void unionDU(int node1, int node2) {
		int root1=find(node1);
		int root2=find(node2);
		if(root1!=root2) {
			int depth1=depth(node1);
			int depth2=depth(node2);
			if(depth1>depth2) {
				mID[root2]=mID[root1];
			}
			else {
				mID[root1]=mID[root2];
			}
		}
			
	}

	/**
	 * return the root of the given node.
	 * You should implement the path compression
	 * To do this, we recommend you implement it using recursive.
	 * @param node
	 * 			node number
	 * @return
	 * 			number of the root node where it belong.
	 */
	int find(int node) {
		if (mID[node]==-1)
			return node;
		else
		    return find(mID[node]);
	}
	
	/**
	 * return the depth of the given node
	 * the depth of root is 0
	 * @param node
	 * 			node number
	 * @return
	 * 			depth
	 */
	int depth(int node) {
		
        if(mID[node]==-1)
        	return 0;
        
        size++;	
		return depth(mID[node]);
	}
	
	/**
	 * the number of nodes inside the set where given node belong.
	 * @param node
	 * 			node number
	 * @return
	 * 			the number of nodes
	 */
	int groupSize(int node) {
		int groupsize=0;
		while(mID[node]!=-1)
			groupsize++;
		return groupsize;
	}
	
	/**
	 * return true if node1 and node2 are in the same set
	 * return false otherwise
	 * @param node1, node2
	 * 			node numbers
	 * @return
	 * 			boolean value
	 */
	boolean inSameGroup(int node1, int node2) {
		int root1=find(node1);
		int root2=find(node2);
		if(root1==root2)
			return true;
		else 
			return false;
	}
	
	/**
	 * the number of groups in this union structure.
	 * @param
	 * @return
	 * 			the number of groups
	 */
	int numberOfGroups() {
		int i=9, gsize=0;
		while(i>=0){
			 i=find(i);
			 gsize++;
			 
		}
		return gsize;
	}
	
	/**
	 * Print the elements of this union with following rules
	 * 
	 * When each node in the different sets,
	 * (0)(1)(2)(3)(4)(5)(6)(7)(8)(9)
	 * 
	 * Then if 1 and 2 are in the same set,
	 * (0)(1,2)(3)(4)(5)(6)(7)(8)(9)
	 * 
	 * We don't care about the order of set.
	 * Please just make sure that nodes in the same set represented by ()
	 * (0,4,5)(1,2,3)(6,7,8,9)
	 */
	void print() {
           int i=9,j,k;
           while(i>=0){
        	 j=i;  
  			 k=find(i);
  			 
  			if(k!=-1) {
  			 
  			 System.out.println("("+mID[k]);
  			 k++;
  			 while(k<=j) {
  				System.out.println(","+mID[k]);
  			      k++;
  			 }
  			 i--;
  			}
           System.out.println(")");
  			 
  		}
		
	}
}
