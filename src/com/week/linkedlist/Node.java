package com.week.linkedlist;

public class Node {

    int data;
    Node next;

    public Node(int d){
        this.data=d;
        this.next=null;
    }

    public void appendToTail(int d){

        Node tailNode=new Node(d);
        Node n =this;
        while(n.next!=null){
            n=n.next;
        }
        n.next=tailNode;
    }

    public void main(String[] args){
       // LinkedList
    }
}
