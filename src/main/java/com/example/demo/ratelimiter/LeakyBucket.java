package com.example.demo.ratelimiter;

import java.util.concurrent.*;

/**
 * @author Mukesh Verma
 */
public class LeakyBucket {
    BlockingQueue<Integer> queue;
    long maxTokens;

    public LeakyBucket(int maxTokens) {
        this.queue = new ArrayBlockingQueue<>(maxTokens);
        Runnable task=()->processRequest();
        Thread th=new Thread(task,"Scheduler-Thread");
        th.start();
    }

    public boolean aquireToken(int request) {
        if(queue.offer(request)){
            System.out.println("token acquire : "+ queue.size());
            return true;
        }
        System.out.println("token not acquire : "+ queue.size());
       return  false;
    }

    private void processRequest() {
        while (true) {
            if (Boolean.FALSE.equals(queue.isEmpty())) {
                int request = queue.poll();
                handleRequest(request);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

    private void handleRequest(int request) {
        System.out.print(Thread.currentThread().getName());
        System.out.println("processing request: " + request);

    }


}
