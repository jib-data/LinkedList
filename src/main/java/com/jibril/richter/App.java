package com.jibril.richter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList myll = new LinkedList(2);
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
