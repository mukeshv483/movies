package com.example.demo.list;

/**
 * @author Mukesh Verma
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(happyNumber(4));

    }
    private static boolean happyNumber(int n){

        int slowPointer=squaredDigitSum(n);
        int fastPointer=squaredDigitSum(slowPointer);
        while(fastPointer!=1 && fastPointer!=slowPointer){
            slowPointer=squaredDigitSum(slowPointer);
            fastPointer=squaredDigitSum(squaredDigitSum(fastPointer));
            System.out.println("fast: "+fastPointer);
            System.out.println("slow "+slowPointer);
        }
        return fastPointer==1;
    }



    private static int squaredDigitSum(int num){
        int sum=0;
        while(num>0){
            int digit=num%10;
            num=num/10;
            sum=digit*digit+sum;
        }
        return sum;

    }
}
