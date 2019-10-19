package com.justnow.shellsort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8,2,4,10,13,16,1,17,9,18};
        ShellSort sort = new ShellSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public void sort(int[] array) {
        int dk;
        int start;
        int end;
        int n = array.length;
        int temp;
        for(dk=n/2;dk>=1;dk=dk/2){
            for(end=dk; end<n; end++){
                if (array[end] < array[end-dk]){
                    temp=array[end];//因为该间隔的两个元素，后者小于前者，所以需要进行交换
                    for(start = end - dk; start>=0 && temp<array[start];start -= dk){
                        //两个值进行交换
                        array[start+dk] = array[start];
                    }
                    array[start+dk] = temp;
                }
            }
        }
    }
}
