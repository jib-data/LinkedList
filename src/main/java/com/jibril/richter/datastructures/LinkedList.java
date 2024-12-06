package com.jibril.richter.datastructures;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
    public LinkedList(){

    };
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length ++;
    }
    public void printList(){
        Node currentNode = this.head;
        while (currentNode != null){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
    public void getHead(){
        System.out.println("head: " + this.head);
    }
    public void getTail(){
        System.out.println("tail: " + this.tail);
    }
    public void getLength(){
        System.out.println("length: " + this.length);
    }
    public void appendNode(int value){
        Node newNode = new Node(value);
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;

        }
        this.length ++;
    }
    public Node removeLast(){
        if (length == 0 ){
            return null;
        }
        Node currentValue = this.head;
        Node previousValue = this.head;
        while(currentValue.next != null){
            previousValue = currentValue;
            currentValue = currentValue.next;
        }
        this.tail = previousValue;
        this.tail.next = null;
        this.length --;
        if(this.length == 0){
            this.tail = null;
            this.head = null;
        }
        return currentValue;
    }

    public void prependNode(int value){
        Node newNode = new Node(value);
        if (this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {
//            New Node should point to the current element that the head is pointing to.
            newNode.next = this.head;
//            the head should now point to the new node.
            this.head = newNode;
        }
        this.length ++;
    }
    public Node removeFirstNode(){
        if (this.length == 0){
            return null;
        }
        Node removedNode = this.head;
        this.head=  this.head.next;
        removedNode.next = null;
        this.length --;

        if (this.length == 0){
            this.tail = null;
        }

        return removedNode;
    }
    public Node getNode(int index){
        if (index < 0 || index >= this.length){
            return null;
        }
        Node currentNode = this.head;
        for (int i = 0; i < index; i++){
            currentNode= currentNode.next;
        }
        return currentNode;
    }
    public boolean setNode(int index, int value){
        Node temp= this.getNode(index);
        if (temp != null){
            temp.value= value;
            return true;
        } else{
            return false;
        }
    }
    public boolean insertNode(int index, int value){
        if (index <0 || index > this.length){
            return false;
        }
        if(index == 0){
            this.prependNode(value);
            return true;
        }
        if (index == this.length){
            this.appendNode(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = getNode(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }
    public Node removeNode(int index){
        if(index < 0 || index >= this.length){
            return null;
        }
        if (index == 0){
            return removeFirstNode();
        }
        if (index == length-1){
            return removeLast();
        }
        Node prev = this.getNode(index -1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    public void reverseNode(){
        Node temp = this.head;
        this.head = this.tail;
        this.tail= temp;
        Node nextNode = temp.next;
        Node prevNode = null;
        for(int index = 0; index < this.length; index ++){
            nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
    }
    public Node findMiddleNode(){
        Node fast = head;
        Node slow = tail;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop(){
        Node hare = head;
        Node tortoise = head;

        while(hare !=null && tortoise != null){
            hare = hare.next.next;
            tortoise = tortoise.next;

            if(hare == tortoise){
                return true;
            }
        }
        return false;
    }
}
