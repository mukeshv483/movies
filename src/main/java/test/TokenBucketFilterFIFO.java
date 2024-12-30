package test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * @author Mukesh Verma
 */


 public class TokenBucketFilterFIFO {
    private final int capacity;         // Maximum number of tokens the bucket can hold
    private int tokens;                 // Current number of tokens in the bucket
    private final double tokensPerSecond;  // Rate at which tokens are generated per second
    private final BlockingQueue<Request> requestQueue; // Queue to ensure FIFO order for threads

    // Request class to represent a thread waiting for tokens
    private static class Request {
        final Thread thread;
        final int requiredTokens;

        public Request(Thread thread, int requiredTokens) {
            this.thread = thread;
            this.requiredTokens = requiredTokens;
        }
    }

    // Constructor to initialize token bucket with capacity and token generation rate
    public TokenBucketFilterFIFO(int capacity, double tokensPerSecond) {
        this.capacity = capacity;
        this.tokensPerSecond = tokensPerSecond;
        this.tokens = capacity; // Start with a full bucket
        this.requestQueue = new LinkedBlockingQueue<>(); // Ensure FIFO order

        // Scheduled task to refill tokens periodically
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::refillTokens, 0, 100, TimeUnit.MILLISECONDS);
    }

    // Method to refill tokens based on the tokensPerSecond rate
    private synchronized void refillTokens() {
        // Refill tokens based on the time interval (100 ms) and rate
        int tokensToAdd = (int) (tokensPerSecond / 10);  // Convert tokens/second to tokens/100ms
        if (tokens < capacity) {
            tokens += tokensToAdd;
            if (tokens > capacity) {
                tokens = capacity;  // Cap tokens to the maximum capacity
            }
            System.out.println("Refilled tokens: Current tokens = " + tokens);
            // Try to grant tokens to waiting threads in FIFO order
            processQueuedRequests();
        }
    }

    // Process queued requests in FIFO order
    private synchronized void processQueuedRequests() {
        while (!requestQueue.isEmpty() && tokens > 0) {
            Request request = requestQueue.peek();  // Look at the first request in the queue
            if (tokens >= request.requiredTokens) {
                tokens -= request.requiredTokens;
                System.out.println(request.thread.getName() + " allowed: Consumed " + request.requiredTokens + " tokens. Remaining tokens = " + tokens);
                requestQueue.poll();  // Remove the request from the queue
                synchronized (request.thread) {
                    request.thread.notify();  // Notify the waiting thread that it can proceed
                }
            } else {
                break;  // Stop processing if there aren't enough tokens for the next request
            }
        }
    }

    // Method to request tokens and block if insufficient tokens are available
    public void requestTokens(int requiredTokens) throws InterruptedException {
        synchronized (this) {
            if (tokens >= requiredTokens) {
                tokens -= requiredTokens;
                System.out.println(Thread.currentThread().getName() + " allowed immediately: Consumed " + requiredTokens + " tokens. Remaining tokens = " + tokens);
                return;
            }
        }

        // If not enough tokens are available, enqueue the request
        Request request = new Request(Thread.currentThread(), requiredTokens);
        requestQueue.add(request);

        // Block the thread until enough tokens become available
        synchronized (Thread.currentThread()) {
            while (requestQueue.contains(request)) {
                Thread.currentThread().wait();  // Block until tokens are granted
            }
        }
    }

    public static void main(String[] args) {
        TokenBucketFilterFIFO tokenBucketFilter = new TokenBucketFilterFIFO(5, 2);  // 5 capacity, 2 tokens/second

        // Simulating multiple threads requesting tokens
        Runnable task = () -> {
            try {
                tokenBucketFilter.requestTokens(1);  // Each thread requests 1 token
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Start 10 threads simulating incoming requests
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(task, "Thread-" + i);
            t.start();
            try {
                // Simulating random request arrival intervals
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
