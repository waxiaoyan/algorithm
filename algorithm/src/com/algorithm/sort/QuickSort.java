package com.algorithm.sort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,54, 0,290, 0,1,21};
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low,int high){
        if(low < high) {
            int pivot = partition(arr,low,high);
            sort(arr, low, pivot);
            sort(arr,pivot + 1, high);
        }

    }

    private static int getPivot(int low, int high){
        return new Random().nextInt(high - low + 1) + low;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = getPivot(low, high);
        swap(arr, low, pivot);
        int border = low + 1;
        for(int j = border; j <= high; j++) {
            if(arr[j] < arr[low]) {
                swap(arr,j,border);
                border++;
            }
        }
        swap(arr, low, border - 1);
        return border - 1;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
