/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist.linkedlist;

// A node belonging to a singly linked list
public class LinkedListNode<T> {
    // The data contained by the node
    private T data;

    // The next node in the list
    private LinkedListNode<T> next;

    // Creates a new node
    public LinkedListNode(T data) {
        this(data, null);
    }

    // Creates a new node
    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
    
    /*
     * Checks if there is a next node
    */
    public boolean hasNext() {
        return this.next != null;
    }
}