package com.example.demo.bitmanipulatiion;

import java.math.BigDecimal;

/**
 * @author Mukesh Verma
 */
public class Bits {
    public static void main(String[] args) {
        checlkEenOdd(3);
        checkIfPowerOf2(8);
        countSetBits(13);
        getIthBit(5,1);
        setIthBit(8,2);
        clearithBit(15,2);
        rightmostSetBit(12);
    }

    private static void rightmostSetBit(int num) {
        int rightMostSetbit=num & -num;
        System.out.println(rightMostSetbit);

        System.out.println("bits num: "+ Integer.toBinaryString(num));
        System.out.println("bits -num: "+ Integer.toBinaryString(-num));

    }

    private static void clearithBit(int num, int ith) {

        System.out.println("before: "+ Integer.toBinaryString(num));
        num=num & ~(1<<ith);
        System.out.println("set ith bits: "+num);
        System.out.println(" After  "+Integer.toBinaryString(num));

    }

    private static void setIthBit(int num, int ith) {

        System.out.println("before: "+ Integer.toBinaryString(num));
        num=num | (1<<ith);
        System.out.println("set ith bits: "+num);
        System.out.println(" After  "+Integer.toBinaryString(num));

    }

    private static void getIthBit(int num, int ith) {
        int bit=(num>>ith) & 1;

        System.out.println("ith bit: "+bit);
    }

    private static void countSetBits(int n) {
        int count=0;
        while(n>0){
            count+=(n&1);
            n>>=1;//n=n>>1;

        }
        System.out.println("set bits: "+count);
    }

    private static void checkIfPowerOf2(int n) {
        boolean isPowerOf2=(n>0)&&((n&n-1)==0);
        if(isPowerOf2){
            System.out.println("power of 2");
            return;
        }
        System.out.println("not power of 2");
    }

    private static void checlkEenOdd(int i) {
        if((i&1)==1){
            System.out.println("odd");
        }else
            System.out.println("even");

    }
}
