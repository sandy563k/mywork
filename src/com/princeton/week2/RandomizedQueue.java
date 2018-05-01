package com.princeton.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private RandomizedQueueIterator randomizedQueueIterator;
    Node first;

    public RandomizedQueue() {
        // construct an empty randomized queue
        size = 0;
        first = null;
    }

    public boolean isEmpty() {
        // is the randomized queue empty?
        return this.size == 0;
    }

    public int size() {
        // return the number of items on the randomized queue
        return this.size;
    }

    public void enqueue(Item item) {
        // add the item
        if (item != null) {
            Node oldFirst = first;
            first = new Node(item);
            first.next = oldFirst;
            size++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Item dequeue() {
        // remove and return a random item

        if (first != null) {
            int randomPosition = StdRandom.uniform(0, size);
            Node current = first;
            int position = 0;
            while (position < randomPosition) {
                current = current.next;
                position++;
            }

            Node prevNode = current.prev;
            prevNode.next = current.next;

            Item item = current.item;
            current = null;
            size--;
            return item;


        } else {
            throw new NoSuchElementException();
        }
    }

    public Item sample() {
        // return a random item (but do not remove it)
        if (first != null) {
            int randomPosition = StdRandom.uniform(0, size);
            Node current = first;
            int position = 0;
            while (position < randomPosition) {
                current = current.next;
                position++;
            }

            Item item = current.item;
            return item;


        } else {
            throw new NoSuchElementException();
        }
    }

    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        randomizedQueueIterator = new RandomizedQueueIterator();
        return randomizedQueueIterator;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            if (size != 0) {

            } else {
                throw new NoSuchElementException();
            }

            return null;

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
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

    public static void main(String[] args) {
        // unit testing (optional)
    }
}
