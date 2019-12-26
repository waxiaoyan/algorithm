package com.algorithm;

/**
 *  1-->a, 2--->b,......26 --->z
 */
public class InterpretData {
    public static void main(String[] args) {
        // can be interpreted to be 'al', 'aaa','la'
        String data = "1111";
        int num_ways = interpretData(data);
        System.out.println(num_ways);

    }

    static int interpretData(String data) {
        return helper(data, data.length());
    }
    static int helper(String data, int length) {
        // when data is "", there are only one way to interpret it
        System.out.println("length = " + length);
        if(length == 0) {
             return 1;
        }
        // no character starts with "0", so any data starts with "0" has no way to interpret it
        if(data.startsWith("0")) {
            return 0;
        }
        int result = helper(data, length - 1);
        int s = data.length() - length;
        if(length >= 2 && Integer.parseInt(data.substring(s, (s + 2))) <= 26) {
            result += helper(data, length - 2);
        }
        return result;

    }
}
