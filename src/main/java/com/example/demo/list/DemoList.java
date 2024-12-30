package com.example.demo.list;

/**
 * @author Mukesh Verma
 */
public class DemoList {

    public static void main(String[] args) {
        LinkedListMy<Integer> linkedListMy = new LinkedListMy<>();
        linkedListMy.addElement(1);
        linkedListMy.addElement(5);
        linkedListMy.addElement(7);
        linkedListMy.printList();
        System.out.println();
        linkedListMy.removeElement(5);
        linkedListMy.printList();
        System.out.println();
        linkedListMy.removeElement(1);
        System.out.println();
        linkedListMy.printList();
        linkedListMy.removeElement(7);
        System.out.println();
        linkedListMy.printList();

    }
}
