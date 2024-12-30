package com.example.demo.MyHeap;

/**
 * @author Mukesh Verma
 */
public class MinHeap {

    int heapSize;
    int[] heap;
    int capacity;

    public MinHeap(int capacity) {
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
        while (current != 0 && heap[getParent(current)] > heap[current]) {
            swap(current, getParent(current));
            current = getParent(current);
        }


    }

    public void heapify(int index) {
        int smallest = index;
        int left = getLeft(index);
        int right = getRight(index);
        if (left < heapSize && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < heapSize && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }


    }

    public int removeMin(){
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
        MinHeap minHeap = new MinHeap(10);
        minHeap.addElement(10);
        minHeap.addElement(20);
        minHeap.addElement(15);
        minHeap.addElement(30);
        minHeap.addElement(5);

        System.out.println("Min-Heap elements:");
        minHeap.printHeap();

        System.out.println("Removing minimum element: " + minHeap.removeMin());
        minHeap.printHeap();
        System.out.println("Removing minimum element: " + minHeap.removeMin());
        minHeap.printHeap();

    }
}
