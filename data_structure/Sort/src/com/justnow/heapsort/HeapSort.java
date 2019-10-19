package com.justnow.heapsort;

import java.util.Arrays;

public class HeapSort {
    public static  void main(String[] args) {
        int[] array = {53, 17, 78, 9, 45, 65, 87, 32};
        int len = array.length;
        BuildMaxHeap(array, len);

        for(int i=len-1;i>1;i--){
            //在只剩下三个元素的时候，一次排序就可以搞定
            swap(array, 0, i);
            AdjustDown(array, 0, i-1);
        }

        System.out.println(Arrays.toString(array));
    }

    public static void BuildMaxHeap(int[] array, int len){
        for(int i=len/2-1; i>=0; i--){
            AdjustDown(array, i, len);
        }
    }

    public static void AdjustDown(int[] array, int k, int len){
        int temp = array[k];        //暂存待排元素
        for(int i=2*k+1; i<=len-1; i = 2*i+1){
            if(i<len-2 && array[i] < array[i+1]){
                i++;                //取key较大的子结点的下标，i为子结点
            }
            if(temp >= array[i])
                break;
            else{
                array[k] = array[i];//将array[i]调整到双亲结点
                k = i;              //修改k值，以便继续向下筛选
            }
        }
        array[k] = temp;

    }

    public static void swap(int[] array, int m, int n){
        int temp;
        temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
