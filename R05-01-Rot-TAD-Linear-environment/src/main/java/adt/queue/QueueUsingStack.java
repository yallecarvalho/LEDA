package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;


public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);

	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			if(!this.stack2.isEmpty()) 
				this.transferInverted(stack2, stack1);
				
			this.stack1.push(element);
			} catch(StackOverflowException e) {
				throw new QueueOverflowException();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		T result = null;
		
		try {
			if(!this.stack1.isEmpty())      //caso a stack 1 não esteja vazia, faz a transferência pra stack 2.
				this.transferInverted(this.stack1, this.stack2);
				
				result = this.stack2.pop();     // faz o pop na stack2, seguindo o raciocínio da fila. 
			} catch (StackUnderflowException e) {
				throw new QueueUnderflowException();
			} catch (Exception e) {
				e.printStackTrace();
			result = null;
			}
		return result;
	}
		
	
	@Override
	public T head() {
		
		T result = null;
		
		try {
			if(!this.stack1.isEmpty())
				this.transferInverted(this.stack1, this.stack2);
			
			result = this.stack2.top();
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull() || this.stack2.isFull();
	}
	
	//Transfere de forma invertida da stack de entrada pra stack de saída
	private void transferInverted(Stack <T> inputStack, Stack<T> outputStack) throws StackUnderflowException, StackOverflowException {
		while(!inputStack.isEmpty()) {
			outputStack.push(inputStack.pop());
		}
	}

}
