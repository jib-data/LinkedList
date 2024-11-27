package com.jibril.richter;

public class BinarySearchTree {
    private Node root;


    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    BinarySearchTree(){

    }


    public Node getRoot(){
        return root;
    }
}
