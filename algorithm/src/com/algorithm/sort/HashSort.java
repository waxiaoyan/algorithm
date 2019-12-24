package com.algorithm.sort;

import java.util.Arrays;

public class HashSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,-5,7,2};
        int[] arr2 = sortByHash(arr, arr.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    static int[] sortByHash(int[] arr, int length) {
        int maxLength = Arrays.stream(arr).max().getAsInt() + 1;
        int minLength = Math.abs(Arrays.stream(arr).min().getAsInt()) + 1;
        int[] maxHash = new int[maxLength];
        int[] minHash = new int[minLength];
        for (int i = 0; i < length; i++) {
            if(arr[i] >= 0){
                maxHash[arr[i]] = +1;
            }else {
                minHash[-arr[i]] = +1;
            }
        }
        int j = 0;
        for(int i = minLength - 1; i > 0; i--) {
            if(minHash[i] != 0) {
                arr[j] = -i;
                j++;
            }
        }
        for(int i = 0; i < maxLength; i++) {
            if(maxHash[i] != 0) {
                arr[j] = i;
                j++;
            }
        }



        return arr;
    }
}

