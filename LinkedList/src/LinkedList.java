public class LinkedList {
	
	private Node head;
	
	private int size = 0;
	
	public void LinkedList() {
	}
		
	public void add(String element) 
	{
		this.add(this.size, element);
	}
	
	public void add(int index, String element) 
	{
		Node current = null;
		Node newNode = new Node(element, null, null);

		if(head == null) {
			//List is empty... as long as index given is zero, just add
			if (index == 0) {
				head = newNode;				
			}
			else {
				throw new IndexOutOfBoundsException();				
			}
		}
		else {
			current = getNode(index -1);
			if (index > size || index < 0) {
				throw new IndexOutOfBoundsException();				
			}
			
			else {
				if (index == 0) {
					current = getNode(index);
					current.previous = newNode;
					newNode.next = current;
					head = newNode;
				}

				else { 
					//insert new node to previous of current
					Node previousNode = current.previous;
					Node nextNode = current.next;
					if (nextNode == null) {
						newNode.previous = current;
						current.next = newNode;
					}

					else if (previousNode == null) {
						//only need to assign two pointers
						head = newNode;
						newNode.next = current;
						current.previous = newNode;
					}

					else {
						//assign four pointers
						current.previous = newNode;
						previousNode.next = newNode;
						newNode.previous = previousNode;
						newNode.next = current;
					}
				}
			}


		}
			this.size++;
	}
	
	public void clear() 
	{
		
		Node temp = new Node(null, null, null);
		
		while(this.head != null) {
		    temp = this.head;
		    this.head = this.head.next;
		    temp = null;
		  }
		
		size = 0;
	}
	
	private Node getNode(int index) {
		Node current = this.head;
		
		if (index >= 0 && index <= this.size) {
			int i = 0;
			
			while( current != null && i++ < index) {
				current = current.next;
			}
		}
		else {
			current = null;
		}

		return current;
	}
	
	public String get(int index) 
	{
		Node current = this.getNode(index);
		
		if (current != null) {
			return current.value;
		}
		else {
			return "";
		}
	}
	
	public void remove(int index) 
	{
		Node current = getNode(index);
		Node prev = current.previous;
		Node next = current.next;
		
		if (current.next == null && current.previous == null) {
			current = null;
		}
		
		else if (current.next == null) {
			current = null;
			prev.next = null;
		}
		
		else if (current.previous == null) {
			current = null;
			next.previous = null;
			head = next;
		}
		
		else {
			current = null;
			prev.next = next;
			next.previous = prev;
		}
		this.size--;
	}
	
	public void set(int index, String element) 
	{
		Node current = getNode(index);
		current.value = element;
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() 
	{
		String string = "[";
		for (Node node = this.head; node != null; node = node.next) {
			if (node.next == null) {
				string = string + node.value;
			}
			else {
				string = string + node.value +", ";
			}
		}
		string = string + "]";
		return string;
	}

}
