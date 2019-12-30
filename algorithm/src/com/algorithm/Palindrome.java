package com.algorithm;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abfba"));
    }

    public static boolean isPalindrome(String line) {
        int i = 0;
        int j = line.length() -1;
        while(i < j) {
            if(line.charAt(i) != line.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
