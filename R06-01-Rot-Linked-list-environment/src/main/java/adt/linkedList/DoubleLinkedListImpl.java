package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<T>();
		super.head = new DoubleLinkedListNode<T>();
		
	}
	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<T>(),
						new DoubleLinkedListNode<T>());
				this.setHead(auxNode);
				this.setLast(auxNode);
				
				

			} else {
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
					auxNode = (DoubleLinkedListNode<T>) this.getHead();
				}

				while (!auxNode.getNext().isNIL()) {

					if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {

						auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();

					}
				}
				auxNode.setNext(new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), auxNode));

				if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
					this.setLast((DoubleLinkedListNode<T>) auxNode.getNext());
				}

			}
		}	
			
		
		
	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode();
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
		
			newHead.setData(element);
			newHead.setNext(auxHead);
			newHead.setPrevious(new DoubleLinkedListNode<T>());
			auxHead.setPrevious(newHead);
		
			if(this.head.isNIL()) {
				this.last = newHead;
			}	
			this.head = newHead;	
		}
	}

	@Override
	public void removeFirst() {
		if(!this.head.isNIL()) {
			this.head = head.getNext();
			if (this.head.isNIL()) 
				this.last = ((DoubleLinkedListNode<T>) this.head);
			} else {
				DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode();
				auxHead.setPrevious(nil);
				nil.setNext(auxHead);
			
		}
	}
	
	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				
				if (this.size() == 1) {
					
					this.setLast(new DoubleLinkedListNode<T>());
					this.setHead(this.getLast());
				}
				else if (this.getHead().getData().equals(element))
					removeFirst();
				else if (this.getLast().getData().equals(element))
					removeLast();
				else {
					
					DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
					if (this.getHead() instanceof DoubleLinkedListNode<?>) {
						auxNode = (DoubleLinkedListNode<T>) this.getHead();
					}
					while (!auxNode.isNIL() && !auxNode.getData().equals(element)) {
						auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
					}
					if (!auxNode.isNIL()) {
						auxNode.getPrevious().setNext(auxNode.getNext());
						((DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
					}
				}

			}

		}
	}

	@Override
	public void removeLast() {
        if (!this.last.isNIL()) {
            
            this.last = this.last.getPrevious();
            
            if(this.last.isNIL()) {
            	this.head = this.last;
            } else {
                DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();
                this.last.setNext(nil);
                nil.setPrevious(this.last);
            }
        }
    
    } 
	
	@Override
	public T search(T element) {
		T found = null;
		if (!this.isEmpty() && element != null) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();

			while (!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) && !auxHead.getData().equals(element)
					&& !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}

			if (auxHead.getData().equals(element)) {
				found = auxHead.getData();
			}

			if (auxLast.getData().equals(element)) {
				found = auxLast.getData();
			}
		}

		return found;

	}
			
	

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
