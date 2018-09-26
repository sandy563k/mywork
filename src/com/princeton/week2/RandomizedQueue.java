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
            if (first == null) {
                first = new Node(item);
            } else {
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

    public Item dequeue() {
        // remove and return a random item


        if (first != null) {
            int randomPosition = StdRandom.uniform(0, size);
           // randomPosition =1;
             Node current = first;
           // System.out.println("current:" + current + "current.next:" + current.next);
            int position = 0;
            while (position < randomPosition) {
               // System.out.println("current :" + current);
                current = current.next;
                position++;
            }


            // iterate and check
            Node itrr = first;
            while(itrr!=null){
                System.out.print("\t"+itrr.item);
                itrr=itrr.next;
            }
            System.out.println();
            System.out.println("random position:"+randomPosition);
            //remove later


            if (randomPosition == 0) {
                first = first.next;
            } else {
                Node prevNode = current.prev;
                Node nextNode = current.next;
                prevNode.next = nextNode;
                if(nextNode!=null)
                nextNode.prev=prevNode;
            }
            Item item = current.item;
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

        private Node currentHead;
        private int itrSize;


        RandomizedQueueIterator() {
            if (first != null) {
                currentHead = new Node(first.item);
                Node originalListcurrent = first.next;
                Node itrCurrent = currentHead;
                while (originalListcurrent != null) {
                    Node nNode = new Node(originalListcurrent.item);
                    nNode.prev = itrCurrent;
                    itrCurrent.next = nNode;
                    itrCurrent = itrCurrent.next;
                    //System.out.println("currenthead.next   :"+currentHead.next);
                    originalListcurrent = originalListcurrent.next;

                }
                itrSize = size;

                // iterate and check
                Node itrr = currentHead;
                while(itrr!=null){
                  System.out.println("itrr:"+itrr.item);
                  itrr=itrr.next;
                }


            } else {
                currentHead = null;
            }
        }

        @Override
        public boolean hasNext() {
            return currentHead != null;
        }

        @Override
        public Item next() {
            if (currentHead != null) {


                int randomPosition = StdRandom.uniform(0, itrSize);
                //System.out.println("randomPosition:"+randomPosition +" itrSize:"+itrSize);
                Node current = currentHead;
                //System.out.println("currentHead :"+currentHead+" currenthead.next:"+currentHead.next);
                int position = 0;
                while (position < randomPosition) {
                    //  System.out.println("position:"+position+" current:"+current);
                    current = current.next;
                    position++;
                }

                if (randomPosition == 0) {
                    currentHead = currentHead.next;
                } else {
                    Node prevNode = current.prev;
                    Node nextNode = current.next;
                    prevNode.next = nextNode;
                    if(nextNode!=null)
                        nextNode.prev=prevNode;
                }

                Item item = current.item;
                current=null;
                System.out.println("removed item:"+item);
                System.out.println("remaining list");
                itrSize--;
                // iterate and check
                Node itrr = currentHead;
                while(itrr!=null){
                    System.out.print("\t"+itrr.item);
                    itrr=itrr.next;
                }
                System.out.println();
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
