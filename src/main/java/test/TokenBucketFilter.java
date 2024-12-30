package test;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mukesh Verma
 */
public class TokenBucketFilter {
    public TokenBucketFilter(long max_tokens) {
        this.max_tokens = max_tokens;
    }

    long max_tokens;
    long possibleTokens=0;
   long lastRequestTime=System.currentTimeMillis();

  public  synchronized  void  getTokens() throws InterruptedException {
        possibleTokens+= 5 * (System.currentTimeMillis()-lastRequestTime)/1000;
      System.out.println("possibleTokens : "+ possibleTokens);
        if(possibleTokens>max_tokens){
            possibleTokens=max_tokens;
        }

        if(possibleTokens==0){
            System.out.println("token is not available wait for 1 second");
            Thread.sleep(1000);
        }else possibleTokens--;
      lastRequestTime = System.currentTimeMillis();
      System.out.println("token is assigned at : "+Instant.now() +Thread.currentThread().getName());
    }
}
