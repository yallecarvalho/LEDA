package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
		}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		
		while (!aux.isNIL()) {
			size += 1;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		while (!auxHead.isNIL() && auxHead.data != element) {
			auxHead = auxHead.getNext();
		}
		return auxHead.getData();
	}
	

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = head;
		while (!auxHead.isNIL()) {
			auxHead = auxHead.getNext();
			System.out.println(auxHead);
		}
		auxHead.setData(element);
		auxHead.setNext(new SingleLinkedListNode<T>());
		
	}

	@Override
	public void remove(T element) {
		if(head.data == element) {
			head = head.getNext();
		} else {
			SingleLinkedListNode<T> aux = head;
			while(!aux.isNIL() && aux.data != element) {
				aux = aux.getNext();
			} if(!aux.isNIL()) {
				aux.setData(aux.next.data);
				aux.setNext(aux.next.next);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[this.size()];
		int i = 0;
		SingleLinkedListNode<T> aux = head;
		if(head.isNIL()) {
			result = (T[]) new Comparable[0];
		} else {
			while(!aux.isNIL()) {
				result[i] = aux.getData();
				i++;
				aux = aux.getNext();
			}
		}
		
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
