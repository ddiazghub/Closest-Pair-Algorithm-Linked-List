/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package closestpairlinkedlist.linkedlist;

// A singly linked list

import java.util.Iterator;

public class LinkedList<T extends Comparable> implements Iterable<T> {
    // First node in the list, null if empty
    private LinkedListNode<T> head;

    // Last node in the list, null if empty
    private LinkedListNode<T> tail;

    // Number of nodes in the list
    private int length;

    // Creates a new linkedlist
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    // Creates a new linkedlist
    public LinkedList(LinkedListNode<T> head, LinkedListNode<T> tail, int length) {
        this.head = head;
        this.tail = tail;
        this.length = length;
    }
    
    // Checks if the list is empty
    public boolean isEmpty() {
        return this.head == null;
    }
    
    // Adds a node to the list with given data
    public void add(T data) {
        // Creates the node
        LinkedListNode<T> node = new LinkedListNode<>(data);

        if (this.head == null) {
            // If the list is empty, the node is placed at the head
            this.head = node;
        } else {
            // If the list is not empty, the node is placed at the end
            this.tail.setNext(node);
        }

        // The new node becomes the tail of the list and the size is incremented
        this.tail = node;
        this.length++;
    }

    /*
     * Gets the node at the given index
    */
    public LinkedListNode<T> node(int index) {
        if (index > -1 && index < this.length) {
            LinkedListNodeIterator<T> nodes = this.nodes();
                    
            for (int i = 0; i < index; i++)
                nodes.next();
            
            return nodes.next();
        }
        
        return null;
    }
    
    /*
     * Splits the list in half
    */
    public LinkedList<T> split() {
        int mid = this.length / 2;
        LinkedListNode<T> tail = this.tail;
        this.tail = this.node(mid - 1);
        LinkedList<T> newList = new LinkedList<>(this.tail.getNext(), tail, this.length - mid);
        this.length = mid;
        this.tail.setNext(null);
        
        return newList;
    }
    
    /*
     * Sorts an arraylist of points using mergesort
    */
    public void sort() {
        this.mergesort();
    }
    
    /*
     * Recursively sorts an arraylist of points using mergesort
    */
    public void mergesort() {
        if (this.length > 1) {
            LinkedList<T> half = this.split();
            this.mergesort();
            half.mergesort();
            
            this.merge(half);
        }
    }
    
    /*
     * Merges a sorted linked list into this (Also sorted) linked list.
    */
    private void merge(LinkedList<T> list) {
        LinkedListNode<T> current;
        
        if (this.head.getData().compareTo(list.head.getData()) == 1) {
            current = list.head;
            list.head = current.getNext();
            current.setNext(this.head);
            this.head = current;
        } else {
            current = this.head;
        }
        
        while (list.head != null) {
            if (!current.hasNext()) {
                current.setNext(list.head);
                break;
            }
            
            if (current.getNext().getData().compareTo(list.head.getData()) == 1) {
                LinkedListNode<T> temp = current.getNext();
                current.setNext(list.head);
                list.head = list.head.getNext();
                current.getNext().setNext(temp);
            }
            
            current = current.getNext();
        }
        
        this.length += list.length;
    }
    
    /*
     * Appends another linked list to this one
    */
    public void append(LinkedList<T> list) {
        if (this.head == null) {
            // If the list is empty the appended lists's head becomes the head
            this.head = list.head;
        } else {
            // If the list is not empty, the appended list is inserted at the end
            this.tail.setNext(list.head);
        }

        // New tail and size
        this.tail = list.tail;
        this.length += list.length;
    }
    
    /*
     * Gets the first value in the list
    */
    public T first() {
        return this.head == null ? null : this.head.getData();
    }
    
    /*
     * Gets the last value in the list
    */
    public T last() {
        return this.tail == null ? null : this.tail.getData();
    }
    
    public LinkedListNode<T> getHead() {
        return head;
    }

    public LinkedListNode<T> getTail() {
        return tail;
    }

    /*
     * List size
    */
    public int size() {
        return this.length;
    }
    
    /*
     * Gets an iterator through the nodes
    */
    public LinkedListNodeIterator<T> nodes() {
        return new LinkedListNodeIterator<>(this);
    }
    
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }
    
    public String toString() {
        if (this.isEmpty())
            return "[]";
                    
        StringBuilder string = new StringBuilder("[");

        for (T element : this) {
            string.append(element.toString()).append(", ");
        }
        
        string.setLength(string.length() - 2);
        string.append("]");
        
        return string.toString();
    }
}
