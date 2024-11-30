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

    public boolean insertNode(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if(temp.value == newNode.value){
                return false;
            }
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            if(newNode.value > temp.value){
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }

    }
    public boolean contains(int value){
        Node temp = root;

        while(temp !=null){
            if(value > temp.value){
                temp = temp.right;
            } else if (value < temp.value){
                temp = temp.left;
            } else {
                return true;
            }
        }
        return false;
    }
}
