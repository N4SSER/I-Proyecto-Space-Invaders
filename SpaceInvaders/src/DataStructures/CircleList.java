package DataStructures;

public class CircleList<Class> implements List<Class> {
	private Node<Class> head;
	private int size;
	
	public CircleList() {
		head = null;
		size = 0;
	}
	
	@Override
	public void add(Class value) {
		Node<Class> newNode = new Node<Class>();
		newNode.setValue(value);
		if(head == null) {
			head = newNode;
			head.setNext(head);
			++size;
		} else {
			Node<Class> current = head;
			while(current.getNext() != head) {
				current = current.getNext();
			}
			current.setNext(newNode);
			newNode.setNext(head);
			++size;
		}
	}

	@Override
	public void remove(int index) {
		if(index == 0 && index < size) {
			head = head.getNext();
			--size;
		} else {
			Node<Class> current = head;
			int counter = 0;
			while(counter < index-1) {
				current = current.getNext();
				counter++;
			}
			current.setNext(current.getNext().getNext());
			--size;
		}
	}

	@Override
	public Class get(int index) {
		Node<Class> current = head;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getValue();
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}
	
	@Override
	public void swap(int index1, int index2) {
		Class d1 = this.get(index1);
		Class d2 = this.get(index2);
		Node<Class> current = head;
		for(int c = 0; c < this.size(); c++) {
			if(this.get(c) == d1) {
				current.setValue(d2);
			} else if(this.get(c) == d2) {
				current.setValue(d1);
			}
			current = current.getNext();
		}
	}
}