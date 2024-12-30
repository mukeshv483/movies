package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Mukesh Verma
 */
public class DemoTokenBucket {
    public static void main(String[] args) throws InterruptedException {
        TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(50);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Runnable r1 = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    tokenBucketFilter.getTokens();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        List<Thread>threads=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(r1));
        }

        threads.stream().parallel().forEach(thread -> {
                 thread.start();
                    try {
                        thread.join();
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}


 class TokenBucketFilter1 {
    private int capacity;  // The maximum number of tokens the bucket can hold
    private int tokens;    // Current number of tokens in the bucket
    private int refillRate; // Rate of token refill per second (e.g., 1 token/sec)

    // Initialize the token bucket with the given capacity and refill rate
    public TokenBucketFilter1(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity; // Start with a full bucket

        // Refill tokens periodically based on the refill rate
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::refillTokens, 0, 1, TimeUnit.SECONDS);
    }

    // Method to refill tokens based on the refill rate
    private synchronized void refillTokens() {
        if (tokens < capacity) {
            tokens += refillRate;
            if (tokens > capacity) {
                tokens = capacity;  // Cap the tokens to the bucket's maximum capacity
            }
            System.out.println("Refilled tokens: Current tokens = " + tokens);
        }
    }

    // Method to handle an incoming request, consuming a token if available
    public synchronized boolean allowRequest() {
        if (tokens > 0) {
            tokens--;
            System.out.println("Request allowed: Remaining tokens = " + tokens);
            return true;
        } else {
            System.out.println("Request denied: No tokens available");
            return false;
        }
    }

    public static void main(String[] args) {
        TokenBucketFilter1 tokenBucketFilter = new TokenBucketFilter1(5, 1);

        // Simulating incoming requests
        for (int i = 0; i < 10; i++) {
            boolean allowed = tokenBucketFilter.allowRequest();
            if (!allowed) {
                System.out.println("Request " + i + " rejected due to rate limit.");
            }

            try {
                // Simulate random request intervals (500 ms)
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
