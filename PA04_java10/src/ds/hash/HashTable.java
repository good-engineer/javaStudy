package ds.hash;

public class HashTable{
	
	Item [] table;
	int m;
	int c1, c2, c3;
	
	private int hash(String k) {
		// Fill in your codes
		
		int index=0;
		index=k.hashCode()%m;
		if(table[index]!=null &&( table[index].getKey().compareTo(k)!=0)) {
			int i=0,p=0,newindex=index;
			while(table[newindex]!=null && ( table[newindex].getKey().compareTo(k)!=0)) {
			    
				p=c1*(i^2)+c2*i+c3;
			
			    newindex=p+index+1;
			    newindex=newindex%m;
			    i++;
		
			}
		  index=newindex;	
		}
		
		    
		return index;
	}
	
	public HashTable(int n) {
		// fill in your code 
		m=n;
		table=new Item[n+1];
		
	}

	public void Create(int c1, int c2, int c3){
		this.c1=c1;
		this.c2=c2;
		this.c3=c3;
		// fill in your code 
	    
	}
	
	public void Insert(String key, int value){
		// fill in your code 
		
		int index = hash(key);
		
	    Item item=new Item(key,value);
	    
		if (table[index]==null){
			
			table[index]=item;
			
			
		}
		else 
			table[index].setValue(value);
		
	
		/** This is the sample output format. 
		 *  You'd better use this format to output your answer.
		 */
		System.out.println("Insert: (" + key + ", " + value + ") / " + "INDEX: " + index);
	}

	public void Delete(String key){
		// fill in your code 
		
		int index = hash(key);
		int value =0;
		//table[index].getHeap().print();
		if (table[index]==null || table[index].getKey().compareTo(key)!=0) {
	
			System.out.println("Failed to find " + key);
		    return ;
		}
		value=table[index].removemax();
		if (table[index].getHeap().isEmpty())
			table[index]=null;
		/** This is the sample output format. 
		 *  You'd better use this format to output your answer.
		 */
		System.out.println("Delete: (" + key + ", " + value + ") / " + "INDEX: " + index);
		
	}
	
	public void Search(String key){
		// fill in your code 
		int index = hash(key);
		int value =0;
		//table[index].getHeap().print();
		if (table[index]==null || table[index].getKey().compareTo(key)!=0) {
			System.out.println("Failed to find " + key);
		    return;}
		
		value=table[index].max();
		
		
		/** This is the sample output format. 
		 *  You'd better use this format to output your answer.
		 */
		System.out.println("Search: (" + key + ", " + value + ") / " + "INDEX: " + index);
		
	}
}
