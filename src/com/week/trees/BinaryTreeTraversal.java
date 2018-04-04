package com.week.trees;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BinaryTreeTraversal {

    public static void inOrderTreeTraversal(BinarySearchTreeNode node) {
        if (node != null) {
            inOrderTreeTraversal(node.left);
            visit(node);
            inOrderTreeTraversal(node.right);
        }

    }

    public static void PreOrderTreeTraversal(BinarySearchTreeNode node) {
        if (node != null) {
            visit(node);
            PreOrderTreeTraversal(node.left);
            PreOrderTreeTraversal(node.right);
        }

    }

    public static void PostOrderTreeTraversal(BinarySearchTreeNode node) {
        if (node != null) {
            PostOrderTreeTraversal(node.left);
            PostOrderTreeTraversal(node.right);
            visit(node);
        }
    }

    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int num) {
            value = num;
            left = null;
            right = null;
        }

    }

    public static void visit(BinarySearchTreeNode node) {
        System.out.print(node.data +" ");
    }

    //create a tree to examine above cases
    public static BinarySearchTreeNode createTree() {
        BinarySearchTreeNode root = new BinarySearchTreeNode(10);
        for (int i = 0; i < 20; i++) {
            root.insert(ThreadLocalRandom.current().nextInt(0, 21));
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode treeNode = createTree();
        System.out.println("printing inorder traversal");
        inOrderTreeTraversal(treeNode);
        System.out.println("\n\nprinting Preorder traversal");
        PreOrderTreeTraversal(treeNode);
        System.out.println("\n\nprinting Postorder traversal");
        PostOrderTreeTraversal(treeNode);
    }

}


