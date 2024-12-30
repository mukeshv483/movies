package com.example.demo.tree;

import lombok.Data;

/**
 * @author Mukesh Verma
 */
@Data
public class BST {
    public static void main(String[] args) {
        BST bst=new BST();
        bst.root=new Node(0);
        bst.getRoot().left=new Node(5);
        bst.getRoot().right=new Node(8);
        bst.insert(6);
        bst.insert(3);
        bst.print();
    }
    Node root;
    @Data
    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value){

        root=insertUtil(value, root);

    }

    private Node insertUtil(int value, Node node) {

        if(node==null){
           return new Node(value);
        }
        if(value  <  node.getValue() ){
            node.left=insertUtil(value,node.getLeft());
        }
        else {
            node.right=insertUtil(value,node.right);
        }
        return  node;
    }

    public void print(){
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root==null){
            return;
        }
        System.out.println("Value: "+ root.getValue());
        preOrder(root.left);
        preOrder(root.right);
    }
}
