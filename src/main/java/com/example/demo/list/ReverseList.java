package com.example.demo.list;


/**
 * @author Mukesh Verma
 */
public class ReverseList {
    public static void main(String[] args) {
        LinkedListMy<Integer>list=new LinkedListMy<>();
        list.addElement(1);
        list.addElement(4);
        list.addElement(3);
        list.addElement(6);
        list.reverse();
        list.printList();

    }
}
