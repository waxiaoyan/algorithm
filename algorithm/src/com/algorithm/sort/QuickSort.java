package com.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,54, 0,290, 0,1,21};
        sort(arr,0,arr.length - 1);
        print(arr);
    }

    private static void sort(int[] arr, int low,int high){
        if(low < high) {
            int pivot = partition(arr,low,high);
            sort(arr,low,pivot - 1);
            sort(arr,pivot + 1, high);

        }

    }

    private static int partition(int[] arr,int low, int high) {
        int pivot = arr[high];
        int j = low;
        for (int i = low; i <= high -1 ; i++) {
            if(arr[i] < pivot){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        int n = arr[j];
        arr[j] = pivot;
        arr[high] = n;
        return j;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
