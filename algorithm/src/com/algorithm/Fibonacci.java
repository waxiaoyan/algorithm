package com.algorithm;

/**
 * 1 1 2 3 5 8
 * when n is 3, return 2, when n is 8, return 6
 *
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        int[] memoize = new int[n + 1];
        return fibMemoize(n,memoize);
    }

    public static int fibMemoize(int n,int[] memoize) {
        if(memoize[n] != 0) {
            return memoize[n];
        }
        int result = 0;
        if(n == 1 || n == 2) {
            result = 1;
        }else {
           result = fibMemoize((n - 1),memoize) +fibMemoize((n - 2),memoize);
           memoize[n] = result;
        }
        System.out.println("n = " + n + ",memoize[" +n+ "]=" + memoize[n]);
        return result;
    }

    public static int fibBottomUp(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        int[] bottomup = new int[n + 1];
        bottomup[1] = 1;
        bottomup[2] = 1;
        for (int i = 3; i < bottomup.length; i++) {
            bottomup[i] = bottomup[i - 1] + bottomup[i - 2];
        }
        return bottomup[n];
    }
}
