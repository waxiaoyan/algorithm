package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class SumPair {
    public static void main(String[] args) {
        int[] a1 = {-1, 3, 8, 2, 9, 5};
        int[] a2 = {4, 1, 2, 10, 5, 20};
        int aTarget = 24;
        closestSumPair(a1, a2, aTarget);// should return {5, 20} or {3, 20}

        int[] b1 = {7, 4, 1, 10};
        int[] b2 = {4, 5, 8, 7};
        int bTarget = 13;
        // closestSumPair(b1, b2, bTarget) should return {4, 8}, {7, 7}, {7, 5}, or {10, 4}

        int[] c1 = {6, 8, -1, -8, -3};
        int[] c2 = {4, -6, 2, 9, -3};
        int cTarget = 3;
        // closestSumPair(c1, c2, cTarget) should return {-1, 4} or {6, -3}

        int[] d1 = {19, 14, 6, 11, -16, 14, -16, -9, 16, 13};
        int[] d2 = {13, 9, -15, -2, -18, 16, 17, 2, -11, -7};
        int dTarget = -15;
        // closestSumPair(d1, d2, dTarget) should return {-16, 2}, {-9, -7}
    }

    static void closestSumPair(int[] arr1, int[] arr2,int target) {
        int[] a1 = Arrays.copyOf(arr1,arr1.length);
        Arrays.sort(a1);
        int[] a2 = Arrays.copyOf(arr2,arr2.length);
        Arrays.sort(a2);
        int i = 0;
        int j = a2.length - 1;
        if(((a1[0] + a2[0]) - target) > 0 ) {
            System.out.println("no pair equals to " + target);
            return;
        }
        int[] sumOfpair = {a1[0],a2[0]};
        int different = Math.abs((a1[0] + a2[0]) - target);
        while (i < a1.length && j >= 0) {
            int currentDifferent = a1[i] + a2[j] - target;
            if(currentDifferent == 0) {
                sumOfpair[0] = a1[i];
                sumOfpair[1] = a2[j];
                System.out.println("pair:" + sumOfpair[0] + " +  " + sumOfpair[1] + " = " + target);
                break;
            }
            if(Math.abs(currentDifferent) < different) {
                sumOfpair[0] = a1[i];
                sumOfpair[1] = a2[j];
                different = Math.abs(currentDifferent);
                System.out.println("pair:" + sumOfpair[0] + " +  " + sumOfpair[1] + " = " + target);

                i++;
            }else {
                j--;
            }

        }

    }

}
