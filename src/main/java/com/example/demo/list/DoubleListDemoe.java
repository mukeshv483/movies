package com.example.demo.list;

/**
 * @author Mukesh Verma
 */
public class DoubleListDemoe {
    public static void main(String[] args) {
        DoublyList doublyList=new DoublyList();
        doublyList.addElement(3);
        doublyList.addElement(6);
        doublyList.addElement(7);
        doublyList.addElement(9);
        doublyList.printList();
        doublyList.deleteElement(6);
        doublyList.printList();
        System.out.println();
        doublyList.addElement(5);
        doublyList.printList();
    }
}
