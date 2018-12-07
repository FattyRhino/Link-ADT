/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package link.adt;

/**
 *
 * @author kokho
 */
public class StackLink<T> implements StackInterface<T> {
    private Node topNode;
    
    public StackLink(){
        topNode = null;
    }
    
    public void push(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = topNode;
        topNode = newNode;
    }
    
    public T pop(){
        T top = peek();
        
        if (!isEmpty()){
            topNode = topNode.next;
        }
        
        return top;
    }
    
    public T peek(){
        T top = null;
        
        if (!isEmpty()){
            top = topNode.data;
        }
        
        return top;
    }
    
    public boolean isEmpty(){
        return topNode == null;
    }
    
    public void clear(){
        topNode = null;
    }
    
    private class Node{
        private T data;
        private Node next;
        
        private Node(T data){
            this.data = data;
            this.next = null;
        }
        
        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
