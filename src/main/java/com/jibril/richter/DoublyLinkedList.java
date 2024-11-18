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
    public void printList(){
        Node temp = head;
        while (temp!= null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void appendNode(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length ++;
    }
    public Node removeLast(){
        if(length == 0){
            return null;
        }
        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }else {
            tail = tail.previous;
            tail.next = null;
            temp.previous = null;
        }
        length--;
        return temp;
    }
    public void prependNode(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else{
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if (length == 0){
            return null;
        }
        Node temp = head;
        if (length == 1){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            temp.next = null;
        }
        length --;
        return temp;
    }
    public Node getNode(int index){
        if(index < 0 || index >=length){
            return null;
        }
        Node temp;
        if(index < length/2){
            temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    public boolean setNode(int index, int value){
        Node temp = getNode(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }
        if(index == 0){
            prependNode(value);
            return true;
        }
        if(index == length){
            appendNode(value);
            return false;
        }
        Node newNode = new Node(value);
        Node before = getNode(index -1);
        Node after = before.next;
        newNode.previous = before;
        newNode.next = after;
        before.next = newNode;
        after.previous= newNode;
        length++;
        return true;
    }
    public Node removeNode(int index){
        if(index<0 || index >= length){
            return null;
        }
        if (index == 0){
           return removeFirst();
        }
        if (index == length - 1){
            return removeLast();
        }
        Node temp = getNode(index);
        Node after = temp.next;
        Node before = temp.previous;
        temp.next = null;
        temp.previous = null;
        before.next = after;
        after.previous = before;
        length --;
        return temp;
    }
}
