package com.example.demo.MyHeap;

/**
 * @author Mukesh Verma
 */
public class MaxHeap {

    int heapSize;
    int[] heap;
    int capacity;

    public MaxHeap(int capacity) {
        this.heapSize = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void addElement(int value) {
        if (heapSize == capacity) throw new RuntimeException("capacity is full");
        if (heapSize < capacity) {
            heap[heapSize] = value;
        }
        int current = heapSize;
        heapSize++;
        while (current != 0 && heap[getParent(current)] < heap[current]) {
            swap(current, getParent(current));
            current = getParent(current);
        }


    }

    public void heapify(int index) {
        int greatest = index;
        int left = getLeft(index);
        int right = getRight(index);
        if (left < heapSize && heap[left] > heap[greatest]) {
            greatest = left;
        }
        if (right < heapSize && heap[right] > heap[greatest]) {
            greatest = right;
        }
        if (greatest != index) {
            swap(index, greatest);
            heapify(greatest);
        }


    }

    public int removeMax(){
        if(heapSize< 0){
            throw new RuntimeException("heap is empty");
        }
        if(heapSize==1){
            heapSize--;
            return heap[0];
        }

        int root=heap[0];
        heap[0]=heap[heapSize-1];
        heapSize--;
        heapify(0);
        return  root;
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MaxHeap minHeap = new MaxHeap(10);
        minHeap.addElement(10);
        minHeap.addElement(20);
        minHeap.addElement(15);
        minHeap.addElement(30);
        minHeap.addElement(5);

        System.out.println("Max-Heap elements:");
        minHeap.printHeap();

        System.out.println("Removing max element: " + minHeap.removeMax());
        minHeap.printHeap();
        System.out.println("Removing max element: " + minHeap.removeMax());
        minHeap.printHeap();

    }
}
