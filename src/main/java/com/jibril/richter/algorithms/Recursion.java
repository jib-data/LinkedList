package com.jibril.richter.algorithms;

public class Recursion {

    public void forLoop(int index){
        for (int i = 0; i < index; i++){
            System.out.println(i);
        }
    }

    public void recursiveLoop(int index){
        if (index == 0){
            System.out.println(index);
            return;
        }
        recursiveLoop(index-1);
        System.out.println(index);
    }
}
