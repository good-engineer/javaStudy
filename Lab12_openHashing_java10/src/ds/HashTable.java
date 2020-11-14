package ds;

import java.lang.reflect.Array;

public class HashTable<Key extends Comparable<? super Key>, E> {
	private int M; // Size of the table
	private KVpair<Key, E>[] T; // Array of the elements

	@SuppressWarnings("unchecked") // Allow the generic array allocation
	public HashTable(int m) {
		// Fill in your codes
		this.M=m;
		T=new KVpair[this.M];
		
	}

	/** Insert record r into T */
	public void hashInsert(Key k, E r) {
		// Fill in your codes
        int index=hash(k);
        KVpair<Key, E> curr=new <Key,E>KVpair(k,r);
        KVpair<Key, E> prev=new <Key,E>KVpair();
        if(T[index]==null)
        	T[index]=curr;
        else {
        	prev=T[index];
        	while(prev.next()!=null)
        		prev=prev.next();
        	
        	prev.set_next(curr);
        		
        }
     }

	/** Search for the record with key k */
	public E hashSearch(Key k) {
		// Fill in your codes
		int index=hash(k);
		KVpair<Key, E> curr=new <Key,E>KVpair();
		for(curr=T[index];curr!=null;curr=curr.next()) {
			if(curr.key()==k)
				return curr.value();
		}
		
		return null;
	}

	/** Remove a record with key value k from the hash table */
	public E hashRemove(Key k) {
		// Fill in your codes
		E value;
		int index=hash(k);
		KVpair<Key, E> curr=new <Key,E>KVpair();
		KVpair<Key, E> prev=new <Key,E>KVpair();
		if(T[index].key()==k) {
			 value =T[index].value();
			T[index]=T[index].next();
			return value;
		}
		prev=T[index];
		curr=prev.next();
		while(curr!=null) {
			if(curr.key()==k) {
				prev.set_next(curr.next());
				value=curr.value();
				curr=null;
				return value;
			}
			else {
				prev=curr;
				curr=curr.next();
			}
				
		}
		return null;
	}

	/**
	 * If the key is an Integer, then use a simple mod function for the hash
	 * function. If the key is a String, then use folding.
	 */
	private int hash(Key k) {
		// Fill in your codes
		int index=(int)k%10;
		return index;
	}
}

