package com.week.trees;

public class BinarySearchTree {

    class Node {
        Node left, right;
        int data;

        public Node(int value) {
            this.data = value;
        }

        void insert(int value) {
            if (value <= data) {
                //insert on left side
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }

            } else {
                //insert on right side
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }

            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            } else if (value > data) {
                if (right != null) {
                    return right.contains(value);
                }

            } else {
                if (left != null) {
                    return left.contains(value);
                }
            }
            return false;
        }


        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.println(data);
            if (right != null) {
                right.printInOrder();
            }
        }
    }


}


