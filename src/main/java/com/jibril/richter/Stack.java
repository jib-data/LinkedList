package com.jibril.richter;

public class Stack {
    private Node top;
    private int length;


    public class Node{
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        length=1;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (length == 0){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }
    public Node pop(){
        if (top == null){
            return null;
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
            length--;
            return temp;
        }
    }
}
