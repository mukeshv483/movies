package com.example.demo.subsequence;

/**
 * @author Mukesh Verma
 */
public class ShortestPallindrome {
    public static void main(String[] args) {
        Solution shortestPallindrome =new Solution();
        shortestPallindrome.shortestPalindrome("abb");

    }
}
class Solution {
    public String shortestPalindrome(String s) {
        // we use a prime number as a base for computing rolling hash
        final int base = 131;
        // modular multiplication factor, initially 1
        int multiplier = 1;
        // we will use a large prime number to mod the result to avoid overflow
        final int mod = (int) 1e9 + 7;
        // rolling hash from the front
        int prefixHash = 0;
        // rolling hash from the back
        int suffixHash = 0;
        // the index till the string is a palindrome
        int palindromeIdx = 0;
        // length of the string
        int length = s.length();

        // iterate through the string to update the prefix and suffix hashes
        for (int i = 0; i < length; ++i) {
            // convert character to number (assuming lowercase 'a' to 'z')
            int charValue = s.charAt(i) - 'a' + 1;
            // update the prefix hash and ensure it is within the bounds by taking modulo
            prefixHash = (int) (((long) prefixHash * base + charValue) % mod);
            // update the suffix hash and ensure it is within the bounds by taking modulo
            suffixHash = (int) ((suffixHash + (long) charValue * multiplier) % mod);
            // update the multiplier for the next character
            multiplier = (int) (((long) multiplier * base) % mod);

            // if the prefix and suffix are equal, then we know the string up to index i is a palindrome
            if (prefixHash == suffixHash) {
                palindromeIdx = i + 1;
            }
        }

        // If the whole string is a palindrome, return it as is
        if (palindromeIdx == length) {
            return s;
        }

        // We need to add the reverse of the substring from palindromeIdx to the end to the front
        // to make the string a palindrome
        String suffixToBeAdded = new StringBuilder(s.substring(palindromeIdx)).reverse().toString();

        // Return the string with the suffix added in front to form the shortest palindrome
        return suffixToBeAdded + s;

    }




}
//abcd
//aacecaaa
// aaacecaaa


