package com.jibril.richter;

import com.jibril.richter.algorithms.Recursion;
import com.jibril.richter.datastructures.BinarySearchTree;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        DoublyLinkedList dll = new DoublyLinkedList(3);
//        dll.appendNode(4);
//        dll.prependNode(1);
//        dll.appendNode(77);
//
////        dll.printList();
////        dll.removeLast();
//        dll.setNode(3, 100);
////        dll.printList();
//        System.out.println( dll.getNode(3).value);

        Recursion recursion = new Recursion();
//        recursion.forLoop(5);
        recursion.recursiveLoop(100);

    }
}
