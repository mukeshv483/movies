package com.example.demo.list;


import java.net.InetAddress;

/**
 * @author Mukesh Verma
 */
public class LinkedListMy<T extends Comparable<T>> {
    ListNode<Integer> head;
    ListNode<Integer> tail;

    public LinkedListMy(){
        this.head=null;
        this.tail=null;
    }

    public void addElement(int value){
        ListNode node=new ListNode<>(value);
        if(head==null){
          head=node;
          tail=node;
          return;
        }
        tail.setNext(node);
        tail=tail.getNext();
    }

    public  void  removeElement(Integer value){
         if(head==null || tail==null){
             throw new RuntimeException("list is empty");
         }

         ListNode temp=head;
         ListNode prev=null;

         while(temp!=null && temp.getData().compareTo(value)!=0){
             prev=temp;
             temp= temp.getNext();
         }
         if(prev!=null){
             prev.setNext(temp.getNext());
         }
         else
             head=head.getNext();

        if(temp==tail){
            tail=prev;
        }

    }
    public void printList(){
        ListNode<Integer>temp=head;
        while(temp!=null){
            System.out.print(temp.getData());
            System.out.print("->");
            temp= temp.getNext();
        }
        System.out.print("null");
    }

    public void reverse() {
      reverseList(head);

    }

    private ListNode<Integer> reverseList(ListNode<Integer> listNode) {
        if(listNode !=null && listNode.getNext()==null){
            head=listNode;
            return listNode;
        }
        ListNode<Integer> node=reverseList(listNode.getNext());
        // node : 3 listNode 2
        node.setNext(listNode);
        listNode.next=null;
        return  listNode;
    }
}
// 1->2->3->null
//
