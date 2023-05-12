package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		super.head = new DoubleLinkedListNode<T>();
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode();
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
		
		newHead.setData(element);
		newHead.setNext(auxHead);
		newHead.setPrevious(new DoubleLinkedListNode<T>());
		auxHead.setPrevious(newHead);
		
		if(super.head.isNIL()) {
			this.last = newHead;
		}	
		super.head = newHead;		
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
