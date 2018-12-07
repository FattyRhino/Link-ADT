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
public class QueueLink<T> implements QueueInterface<T> {
    private Node lastNode;
    
    public QueueLink(){
        lastNode = null;
    }
    
    public void enqueue(T newEntry){
        Node newNode = new Node(newEntry);
        
        if (isEmpty()){
            newNode.next = newNode;
            
        }
        else{
            newNode.next = lastNode.next;
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }
    
    public T dequeue(){
        T front = null;
        
        if (!isEmpty()){
            front = lastNode.next.data;
            
            if(lastNode.next == lastNode){
                lastNode = null;
            }
            else{
                lastNode.next = lastNode.next.next;
            }
        }
        
        return front;
    }
    
    public T getFront(){
        T front = null;
        
        if (!isEmpty()){
            front = lastNode.next.data;
        }
        
        return front;
    }
    
    public boolean isEmpty(){
        return lastNode == null;
    }
    
    public void clear(){
        lastNode = null;
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
