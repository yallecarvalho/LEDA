package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.root);

	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> resultNode = new BSTNode<>();
		if (element != null && !node.isEmpty()) {
			if (node.getData().equals(element)) {
				resultNode = node;
			} else {
				if (node.getData().compareTo(element) > 0) {
					resultNode = search(element, (BSTNode<T>) node.getLeft());
				} else {
					resultNode = search(element, (BSTNode<T>) node.getRight());
				}
			}
		}
		return resultNode;
	}

	@Override
	public void insert(T element) {
		if (element != null & search(element).isEmpty()) {
			this.insert(element, this.root);
		}

	}

	private void insert(T element, BSTNode<T> node) {

		if (node.isEmpty()) {
			node.setData(element);  //adiciona o elemento como dado no nó
			node.setLeft(new BSTNode<>()); //seta o nó da esquerda como NIL
			node.setRight(new BSTNode<>());  //seta o nó da direita como NIL
			node.getLeft().setParent(node); //seta o parente da esquerda como o nó
			node.getRight().setParent(node); //seta o parente da direita como o nó
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert(element, (BSTNode<T>) node.getLeft());
			} else {
				insert(element, (BSTNode<T>) node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> nodeMaximum = new BSTNode<>();
		if (!node.getRight().isEmpty()) {
			nodeMaximum = maximum((BSTNode<T>) node.getRight());
		}
		return nodeMaximum;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> nodeMinimum = new BSTNode<>();
		if (!node.getLeft().isEmpty()) {
			nodeMinimum = minimum((BSTNode<T>) node.getLeft());
		}
		return nodeMinimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				result = minimum((BSTNode<T>) node.getRight());
			} else {
				result = this.sucessor(node);
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> result = (BSTNode<T>) node.getParent();
		if (node.getParent() != null && !result.isEmpty() && node.equals(result.getRight())) {
			result = this.sucessor((BSTNode<T>) node.getParent());
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				result = maximum((BSTNode<T>) node.getLeft());
			} else {
				result = this.predecessor(node);
			}
		}
		return result;
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {
		BSTNode<T> result = (BSTNode<T>) node.getParent();
		if (node.getParent() != null && !result.isEmpty() && node.equals(result.getLeft())) {
			result = this.sucessor((BSTNode<T>) node.getParent());
		}
		return result;

	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setParent(null);
			} else {
				this.remove(node);
			}
		}

	}

	private void remove(BSTNode<T> node) {
		if (!node.getLeft().isEmpty() || !node.getRight().isEmpty()) {
			if (!node.getRight().isEmpty()) {
				node.getRight().setParent(node.getParent());
			} else if (!node.getLeft().isEmpty()) {
				node.getLeft().setParent(node.getParent());
			}
		} else {
			node = this.sucessor(node);
			this.remove(node);
		}
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();
		// preencher
		// postOrder(list.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			// ...
			// ...
			// list.add(node); //aqui provavelmente seria a chamada recursiva
		} else {
			// nao faz nada
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
