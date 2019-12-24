package com.algorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4};
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

}
