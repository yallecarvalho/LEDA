package adt.bt.symetric;

import adt.bt.BTNode;

public class SymetricBTImpl<T> implements SymetricBT<T> {

	protected BTNode<T> root;
	private int cont;

	public SymetricBTImpl() {
		root = new BTNode<T>();
		cont = 1;
	}

	@Override
	public boolean isSymetric() {
		boolean result = false;
		if(!root.isEmpty()){
			if(root.getLeft().getData().equals(root.getRight().getData())){
				result = this.isSymetric(root);
		}
	}
		return result;
	}
	private boolean isSymetric(BTNode<T> node){
		boolean result = false;
		if(node.getLeft().getLeft().getData().equals(node.getRight().getRight().getData()) && node.getLeft().getRight().getData().equals(node.getRight().getLeft().getData())){
			result = isSymetric(node.getLeft()) && isSymetric(node.getRight());
		}
		return result;
	}


	@Override
	public BTNode<T> getRoot() {

		return this.root;
		
	}

	public void insert(T element) {
		if (cont == 1) {
			this.root.setData(element);
			this.root.setLeft(new BTNode<T>(this.root));
			this.root.setRight(new BTNode<T>(this.root));
		}
		if (cont == 2) {
			this.root.getLeft().setData(element);
			this.root.getLeft().setLeft(new BTNode<T>(this.root.getLeft()));
			this.root.getLeft().setRight(new BTNode<T>(this.root.getLeft()));

			this.root.getRight().setData(element);
			this.root.getRight().setLeft(new BTNode<T>(this.root.getRight()));
			this.root.getRight().setRight(new BTNode<T>(this.root.getRight()));
		}

		if (cont == 3) {
			BTNode<T> aux1 = this.root.getLeft().getLeft();
			BTNode<T> aux2 = this.root.getRight().getRight();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}

		if (cont == 4) {
			BTNode<T> aux1 = this.root.getLeft().getRight();
			BTNode<T> aux2 = this.root.getRight().getLeft();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}

		if (cont == 5) {
			BTNode<T> aux1 = this.root.getLeft().getLeft().getLeft();
			BTNode<T> aux2 = this.root.getRight().getRight().getRight();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}

		if (cont == 6) {
			BTNode<T> aux1 = this.root.getLeft().getRight().getRight();
			BTNode<T> aux2 = this.root.getRight().getLeft().getLeft();
			aux1.setData(element);
			aux1.setLeft(new BTNode<T>(aux1));
			aux1.setRight(new BTNode<T>(aux1));

			aux2.setData(element);
			aux2.setLeft(new BTNode<T>(aux2));
			aux2.setRight(new BTNode<T>(aux2));
		}
		cont++;
	}

	public void printTree() {
		System.out.println("          " + this.root);
		System.out.println("     " + this.root.getLeft() + "        " + this.root.getRight());
		System.out.println("   " + this.root.getLeft().getLeft() + "   " + this.root.getLeft().getRight() + "    "
				+ this.root.getRight().getLeft() + "   " + this.root.getRight().getRight());
		System.out.println("  " + this.root.getLeft().getLeft().getLeft() + "     " + this.root.getLeft().getRight().getRight() + "  " + this.root.getRight().getRight().getRight() + "     " + this.root.getRight().getLeft().getLeft());
	}



}