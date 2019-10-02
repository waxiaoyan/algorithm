package com.algorithm.sort;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {54, 0,290,3,2,4,0,1,21};
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        int max = findMax(arr);
        for(int exp = 1; exp < max/exp; exp*=10) {
            countSort(arr,exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int[] count = new int[10];
        int[] output = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i]/exp) % 10] -1] = arr[i];
            count[(arr[i]/exp) % 10] --;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
