package com.example.demo.bitmanipulatiion;

/**
 * @author Mukesh Verma
 */
public class ReverseWords {
    public static void main(String[] args) {
        String word="Hello World  ";
        System.out.println(reverseWordsInPlace(word));
    }


    public static String reverseWordsInPlace(String str) {
        char[] chars = str.toCharArray();
        int start = 0;

        for (int end = 0; end < chars.length; end++) {
            if (chars[end] == ' ' || end == chars.length - 1) {
                int actualEnd = (chars[end] == ' ') ? end - 1 : end;
                reverse(chars, start, actualEnd);
                start = end + 1;
            }
        }

        return new String(chars).trim();
    }

    private static  void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
