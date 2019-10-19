package com.justnow.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {6, 4, 3, 7, 5, 1, 2};
        System.out.println(Arrays.toString(mergeSort.sort(array)));
        int[] a;
        a = Arrays.copyOfRange(array, 1,1);
        System.out.println(Arrays.toString(a));
    }

    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if(arr.length < 2){
            return arr;
        }
        int middle = (int)Math.floor(arr.length/2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    public int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i=0;
        while(left.length > 0 && right.length>0){
            if(left[0] <= right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else{
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while(left.length > 0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while(right.length > 0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }


}
