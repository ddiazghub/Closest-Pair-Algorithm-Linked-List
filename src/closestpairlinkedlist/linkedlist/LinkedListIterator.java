/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist.linkedlist;

import java.util.Iterator;

/**
 * Iterator for values in a linked list
 */
public class LinkedListIterator<T extends Comparable> extends LinkedListBaseIterator<T> implements Iterator<T> {
    public LinkedListIterator(LinkedList<T> list) {
        super(list);
    }
    
    public LinkedListIterator(LinkedListNode<T> head) {
        super(head);
    }
    
    @Override
    public T next() {
        T data = this.current.getData();
        this.current = this.current.getNext();
        
        return data;
    }
}
