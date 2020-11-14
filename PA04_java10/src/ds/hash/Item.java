package ds.hash;

/** This is the data structure of single element in hash table. 
 *  It consists of a (String) key and (MaxHeap) maxHeap.
 *  You are free to add new variables and new functions.
 */
public class Item {
	private String key;
	private MaxHeap<Integer> maxHeap;
	
	
	// fill in your code 
	public void setValue(int value) {
		this.maxHeap.add(value);
	}
	public void setKey(String key) {
		this.key=key;
	}
	public void addValue(int value) {
		this.maxHeap.add(value);
	}
	public Item(String key, int value) {
		
		this.key=key;
		maxHeap= new MaxHeap<Integer>();
		this.maxHeap.add(value);
	}
	public String getKey() {
		return this.key;
		
	}
	public MaxHeap<Integer> getHeap(){
		return maxHeap;
	}
	public int removemax(){
		return maxHeap.removeMax();
	}
	public int max() {
		return maxHeap.returnMax();
	}
	public int getkeyint() {
		return Integer.valueOf(key);
	}

}
