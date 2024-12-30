package test;

import lombok.Data;
import lombok.Synchronized;

/**
 * @author Mukesh Verma
 */
//A blocking queue is defined as a queue which blocks the caller of
// the enqueue method if there’s no more capacity to add the new item being enqueued.
// Similarly, the queue blocks the dequeue caller if there are no items in the queue.
// Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked
// dequeuing thread when an item becomes available in the queue.
public class BoundedBufferProblem {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue=new BlockingQueue(10);
        Runnable r1 =()->{
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.enqueue(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable r2 =()->{
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.dequeue();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}

@Data
class BlockingQueue{
    int data[];
    int head;
    int tail;
    int size;
    int capacity;
    Object producer=new Object();
    Object consumer=new Object();
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        data=new int[capacity];
    }



    public  void enqueue(int val) throws InterruptedException {
        synchronized (data){
            while (size>=capacity) data.wait();
            if(size<capacity){
                data[head]=val;
                head++;
                size++;
                System.out.println("enque: "+val);
                if(head==capacity){
                    head=0;
                }
            }
            data.notifyAll();
        }

    }

    public  int dequeue() throws InterruptedException {
        synchronized (data){
            while (size<=0) data.wait();
            int value=data[tail];
            size--;
            tail++;
            if(tail==capacity){
                tail=0;
            }
            System.out.println("dequeue: "+value);
            data.notifyAll();
            return value;
        }

    }


}