package com.example.demo.ratelimiter;

import java.time.Instant;

/**
 * @author Mukesh Verma
 */
public class TokenBucket {
    int maxTokenPerSeconds;
    Instant lastTimeStamp;
    long availableTokens;
    public TokenBucket(int maxTokenPerSeconds) {
        this.maxTokenPerSeconds = maxTokenPerSeconds;
        this.availableTokens=maxTokenPerSeconds;
        this.lastTimeStamp=Instant.now();
    }



    public synchronized boolean acquireToken(){
       refillTokens();
        if(availableTokens>0){
            availableTokens--;
            System.out.println("token acquire: "+availableTokens);
            return true;
        }
        System.out.println("token  not acquire: "+availableTokens);
        return false;

    }

    private synchronized void refillTokens(){
        long secondsElapsed=Instant.now().getEpochSecond()-lastTimeStamp.getEpochSecond();
        availableTokens=Math.max(0,availableTokens);
        if(availableTokens > maxTokenPerSeconds){
            availableTokens=Math.max(maxTokenPerSeconds*secondsElapsed,availableTokens*secondsElapsed);
        }
        lastTimeStamp=Instant.now();
    }
}
