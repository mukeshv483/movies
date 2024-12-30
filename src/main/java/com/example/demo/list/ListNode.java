package com.example.demo.list;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mukesh Verma
 */
@Data
@NoArgsConstructor
public class ListNode<T extends Comparable<T>> {
    public ListNode(T data) {
        this.data = data;
    }

    private T data;
    ListNode<T> next;

}
