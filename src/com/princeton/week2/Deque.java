package com.princeton.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    Node first, last;
    int size;
    DequeIterator dequeIterator;

    public Deque() {
        // construct an empty deque
        size = 0;
        first = null;
        last = null;
        dequeIterator = new DequeIterator();
    }

    public boolean isEmpty() {
        // is the deque empty?
        return (last == null);
    }

    public int size() {
        // return the number of items on the deque
        return this.size;

    }

    public void addFirst(Item item) {
        // add the item to the front
        if (item != null) {

            if(first==null){
                first = new Node(item);
                last=first;
            }else {
                Node oldFirst = first;
                first = new Node(item);
                first.next = oldFirst;
                oldFirst.prev = first;
            }
            size++;


        } else {
            throw new IllegalArgumentException();
        }


    }

    public void addLast(Item item) {
        // add the item to the end
        if (item != null) {

            if(last == null){
                last = new Node(item);
                first=last;
            }else {


                Node oldLast = last;
                last = new Node(item);
                oldLast.next = last;
                last.prev = oldLast;
            }
            size++;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public Item removeFirst() {
        // remove and return the item from the front
        if (first != null) {
            Item item = first.item;
            first = first.next;
            first.prev = null;
            size--;
            if (size == 0) {
                last = null;
            }
            return item;
        } else {
            throw new NoSuchElementException();
        }
    }

    public Item removeLast() {
        // remove and return the item from the end
        if (last != null) {
            Item item = last.item;
            Node oldLast = last;
            last = last.prev;
            oldLast.prev = null;
            size--;
            if (size == 0) {
                first = null;
            }
            return item;
        }else{
            throw new NoSuchElementException();
        }
    }

    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return this.dequeIterator;


    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null ;
        }

        @Override
        public Item next() {
            if (current != null) {
                Item item = current.item;
                current = current.next;
                return item;
            } else {
                throw new NoSuchElementException();
            }

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        // unit testing (optional)
        Deque deque = new Deque();
        deque.addFirst("a");
        deque.addFirst("b");
        System.out.println(deque.removeLast());

    }

    private class Node {
        Item item;
        Node next;
        Node prev;

        Node(Item itm) {
            item = itm;
            next = null;
            prev = null;
        }
    }
}
