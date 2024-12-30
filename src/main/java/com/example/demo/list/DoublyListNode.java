package com.example.demo.list;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mukesh Verma
 */
@Data
@NoArgsConstructor
public class DoublyListNode<T extends Comparable<T>> {
    public DoublyListNode(T data) {
        this.data = data;
    }

    private T data;
    DoublyListNode<T> next;
    DoublyListNode<T> prev;

}
