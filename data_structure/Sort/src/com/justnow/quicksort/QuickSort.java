package com.justnow.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3,5,8,1,2,9,4,7,6};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int low, int high){
        if(low < high){
            int pivotkey = partition(array,low,high);
            sort(array, low,pivotkey-1);
            sort(array,pivotkey+1, high);
        }
    }

    public int partition(int[] array, int low, int high){
        int pivotkey = array[low];
        while(low < high){
            while(low < high && array[high] > pivotkey)
                high--;
            array[low] = array[high];
            while(low < high && array[low] < pivotkey)
                low++;
            array[high] = array[low];
        }
        array[low] = pivotkey;
        return low;
    }
}
