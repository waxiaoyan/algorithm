package com.algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 54, 0, 290, 0, 1, 21};
        sortArr(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void sortArr(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortArr(arr, left, mid);
            sortArr(arr, mid + 1, right);
            mergeArr(arr, left, mid, right);
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeArr(int[] arr, int left, int mid, int right) {
        int n1 = left;
        int n2 = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (n1 <= mid && n2 <= right) {
            if (arr[n1] > arr[n2]) {
                temp[k] = arr[n2++];
            } else {
                temp[k] = arr[n1++];
            }
            k++;
        }
        while (n1 <= mid) {
            temp[k++] = arr[n1++];
        }
        while (n2 <= right) {
            temp[k++] = arr[n2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
