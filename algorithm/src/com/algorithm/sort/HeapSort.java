package com.algorithm.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,0,2,8,6,3};
        arr = sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] sort(int[] arr) {
        for(int i = arr.length/2; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }

        for(int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr,0, i);
        }
        return arr;
    }

    public static void adjust(int[] arr, int start, int length) {
        int temp = arr[start];
        int left = start*2 + 1;
        int right = start*2 + 2;
        int max = start;
        if(left < length && arr[left] > arr[max]) {
            max = left;
        }
        if(right < length && arr[right] > arr[max]) {
            max = right;
        }
        if(max != start) {
            arr[start] = arr[max];
            arr[max] = temp;
            adjust(arr,max, length);
        }
    }
}
