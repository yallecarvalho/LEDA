package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
    
    		if(!node.isNIL()) {
    			
    			SingleLinkedListNode<T> aux = node;
  
    			while(!aux.isNIL()) {
    				SingleLinkedListNode<T> newNode = aux.getNext();
    				
    				while(!newNode.isNIL()) {
    				
    					if(newNode.getData().equals(aux.getData())) {
    						newNode.setData(newNode.getNext().getData());
    						newNode.setNext(newNode.getNext().getNext());
    					} else {
    						newNode = newNode.getNext();
    					}
    				}
    					aux = aux.getNext();
    			}	
    		}
    	}
    }
    

