/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist.linkedlist;

import java.util.Iterator;

/**
 * Iterator for nodes in a linked list
 */
public class LinkedListNodeIterator<T extends Comparable> extends LinkedListBaseIterator<T> implements Iterator<LinkedListNode<T>> {
    public LinkedListNodeIterator(LinkedList<T> list) {
        super(list);
    }
    
    public LinkedListNodeIterator(LinkedListNode<T> head) {
        super(head);
    }
    
    @Override
    public LinkedListNode<T> next() {
        LinkedListNode node = this.current;
        this.current = this.current.getNext();
        
        return node;
    }
}

