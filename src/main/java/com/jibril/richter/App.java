package com.jibril.richter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyLinkedList myll = new MyLinkedList(2);
        myll.appendNode(4);
        myll.printList();
        myll.removeLast();
        System.out.println(".............................................................................");
        myll.printList();
        myll.removeLast();
        System.out.println(".............................................................................");
        myll.printList();


    }
}
