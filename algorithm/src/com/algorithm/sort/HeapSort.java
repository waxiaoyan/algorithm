package com.algorithm.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,5,3,9,1};
        int[] result = sort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] sort(int[] arr) {
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        for(int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0,i);
        }
        return arr;
    }

    private static void adjust(int[] arr, int i, int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
}
