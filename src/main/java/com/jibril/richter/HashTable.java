package com.jibril.richter;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;


    public class Node{
        public String key;
        public int value;
        public Node next;

        public Node(String key, int value){
            this.key = key;
            this.value =value;
        }

    }

    public HashTable(){
        dataMap = new Node[size];
    }

    private int hashMachine(String key){
        int hash = 0;
        char[] keyChar = key.toCharArray();
        for(int index = 0; index < keyChar.length; index++){
            int asciiValue = keyChar[index];
            hash = (hash + asciiValue * 23) % keyChar.length;
        }
        return hash;
    }

    public void set(String key, int value){
        Node newNode = new Node(key, value);
        int index = hashMachine(key);
        if(dataMap[index]==null){
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hashMachine(key);
        Node temp = dataMap[index];
        while (temp != null){
            if (temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return  0;
    }

    public ArrayList getKeys(){
        ArrayList<String> keys = new ArrayList<>();

        for(int index = 0; index < dataMap.length; index++){
            Node temp = dataMap[index];
            while(temp!=null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }
}
