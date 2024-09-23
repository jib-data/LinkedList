package com.jibril.richter;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length = 0;

    DoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length ++;
    }

    public class Node{
        int value;
        Node next;
        Node previous;

        Node(int value){
            this.value = value;
        }
    }


}
