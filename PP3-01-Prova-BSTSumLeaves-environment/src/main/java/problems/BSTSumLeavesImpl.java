package problems;

import adt.bst.BST;
import adt.bst.BSTNode;

public class BSTSumLeavesImpl implements BSTSumLeaves{
   
	public int sumLeaves(BST<Integer> bst){
       int result = 0;
       if(!bst.isEmpty()) { 
    	 result = this.sumLeaves((BSTNode<Integer>) bst.getRoot());
       }
       
       return result;
    }
	
	private int sumLeaves(BSTNode<Integer> node) {
		
		int sum = 0;
		
		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				sum += node.getData();
			}
			sum += sumLeaves((BSTNode<Integer>) node.getLeft());
			sum += sumLeaves((BSTNode<Integer>) node.getRight());	
		}
		
		return sum;
		
	}
}
