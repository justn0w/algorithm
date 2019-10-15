package com.justnow.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {10,7,19,0,7,29,53,7};
        //总共要经过N-1论比较
        for(int i=0; i<array.length; i++){
            int min = i;
            // 每轮需要比较的次数是N-1
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]){
                    //记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
