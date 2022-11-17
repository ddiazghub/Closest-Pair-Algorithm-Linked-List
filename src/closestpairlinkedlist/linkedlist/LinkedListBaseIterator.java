/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist.linkedlist;

import java.util.Iterator;

/**
 * Iterator for a linked list
 */
public abstract class LinkedListBaseIterator<T extends Comparable> {
    protected LinkedListNode<T> current;
    
    public LinkedListBaseIterator(LinkedList<T> list) {
        this.current = list.getHead();
    }
    
    public LinkedListBaseIterator(LinkedListNode<T> head) {
        this.current = head;
    }
    
    public boolean hasNext() {
        return this.current != null;
    }
}
