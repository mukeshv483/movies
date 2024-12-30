package com.example.demo.list;

/**
 * @author Mukesh Verma
 */
public class DoublyList {
    DoublyListNode<Integer> head;
    DoublyListNode<Integer> tail;

    public DoublyList(){
        this.head=null;
        this.tail=null;
    }
    public void addElement(int value){
        DoublyListNode node=new DoublyListNode(value);
        if(head==null){
            head=node;
            tail=node;
            return;
        }
        node.setPrev(tail);
        tail.setNext(node);
        tail=tail.getNext();
    }
    public void removeNode(DoublyListNode deleteNode){
        if(deleteNode==null){
            return;
        }
        DoublyListNode prev=deleteNode.getPrev();
        DoublyListNode next=deleteNode.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        if(deleteNode==head){
            head=head.getNext();
            head.setPrev(null);
        }
        if(deleteNode==tail){
            tail=tail.getPrev();
            tail.setNext(null);
        }
        deleteNode.setPrev(null);
        deleteNode.setNext(null);

    }
    public void deleteElement(Integer value){
        DoublyListNode node=head;
       while(node!=null && node.getData().compareTo(value)!=0){
           node=node.getNext();
       }
       removeNode(node);
    }


public void printList(){
        DoublyListNode temp=head;
        while(temp!=null){
            System.out.print(temp.getData());
            System.out.print("->");
            temp= temp.getNext();
        }
    System.out.print("null");
}
}
