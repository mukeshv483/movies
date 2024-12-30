package com.example.demo.ratelimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author Mukesh Verma
 */
public class RateLimiter {

    public static void main(String[] args) {
//    TokenBucket  tokenBucket=new TokenBucket(2);
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
//        tokenBucket.acquireToken();
        LeakyBucket leakyBucket=new LeakyBucket(3);
        leakyBucket.aquireToken(1);
        leakyBucket.aquireToken(2);
        leakyBucket.aquireToken(3);
        leakyBucket.aquireToken(4);
        leakyBucket.aquireToken(5);

    }
}
