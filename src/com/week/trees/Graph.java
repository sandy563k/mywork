package com.week.trees;

import java.util.LinkedList;

public class Graph {

    public  class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id){
            this.id =id;
        }
    }
}
