package com.week.trees;

public class BinaryTreeTraversal {

    public void inOrderTreeTraversal(TreeNode node){
        if(node!=null){
            inOrderTreeTraversal(node.left);
            visit(node);
            inOrderTreeTraversal(node.right);
        }

    }
    public void PreOrderTreeTraversal(TreeNode node){
        if(node!=null){
            visit(node);
            PreOrderTreeTraversal(node.left);
            PreOrderTreeTraversal(node.right);
        }

    }
    public void PostOrderTreeTraversal(TreeNode node){
        if(node!=null){
            PostOrderTreeTraversal(node.left);
            PostOrderTreeTraversal(node.right);
            visit(node);
        }
    }

    private  class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int num){
            value=num;
            left=null;
            right=null;
        }

    }

    void visit(TreeNode node){
       System.out.println(node.value);
    }

    //create a tree to examine above cases
    TreeNode createTree(){
        TreeNode root=new TreeNode(0);
        int i=0;
        return root;
    }

    public void main(String[] args){


    }

}


