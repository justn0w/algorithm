package com.justnow.quicksort;

import java.lang.reflect.Method;
import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        int[] array = {10,5,8,1,2,9,4,7,6};
        quickSort2.sort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int left, int right){
        if(left < right) {
            //最终的结果是2两个数字进行比较，所以，肯定会跳出结果来
            int pivotloc = partition(array, left, right);
            sort(array, left, pivotloc - 1);
            sort(array, pivotloc + 1, right);
        }
    }

    public int partition(int[] array, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for(int i=index; i <= right; i++){
            //index作为索引，指向的是大于pivot的数，所以每次当array[i]小于array[privot]时，就要与index索引的元素进行替换。
            if(array[i]<array[pivot]){
                swap(array, i, index);
                index++;
            }
        }
        //总结
        swap(array, pivot, index-1);
        return index-1;
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
