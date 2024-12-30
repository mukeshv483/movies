package com.example.demo.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mukesh Verma
 */
public class UniqueSubsequence {
    static List<String> result=new ArrayList<>();
    public static void main(String[] args) {
        String str="xyyzy";
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        generateUniqueSubSequence(new String(chars));
        System.out.println(result);
    }

    private static void generateUniqueSubSequence(String str) {
        generateUniqueSubSequenceUtil(str,0,"");
    }

    private static void generateUniqueSubSequenceUtil(String input, int index, String current) {
        if(!current.isEmpty()){
            result.add(current);
        }
        for (int i = index; i < input.length(); i++) {
            if(i>0 && input.charAt(i)==input.charAt(i-1)){
                continue;
            }
            generateUniqueSubSequenceUtil(input,i+1,current+input.charAt(i));
        }

    }
}
