
public class MyQueue<E> implements Queue<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;
	

	@Override
	public void enqueue(E item) {
		
		
		if(isEmpty()) {
			this.last=new Node<E>(item,null);
			this.first=this.last;
		
		}
		else{
			this.last.setNext(new Node<E>(item,null));
			this.last=this.last.getNext();
			
		}
		this.size++;
	}
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		else {
		
			E item=this.first.getItem();
			this.first=this.first.getNext();
				size--;
		return item;
		}
		}
		
	
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		else if(this.first==this.last) {
			E item=this.first.getItem();
			this.last=this.first=null;
			this.size=0;
			return item;
		}
		else {
		
			Node<E> n=new Node<E>();;
			n=this.first;
			while(n.getNext()!=this.last) {
				
				n=n.getNext();
			}
			E item =this.last.getItem();
			this.last=n;
			this.last.setNext(null);
			
			this.size--;
			return item;
			
		}
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		Node<E> cursor = first;
		StringBuffer sb = new StringBuffer("(");
		while (cursor != null) {
			sb.append(cursor.getItem());
			if (cursor != last) {
				sb.append(' ');
			}
			cursor = cursor.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

}
