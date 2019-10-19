package com.justnow.BubbleSort;

import java.util.Arrays;

/**
 * 添加一个flag，便可以很快的优化
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个
 * 2、第一轮确定了最大的数字，并将其放到数组的末尾。
 *    第二论就不需要与最后一个数字进行比较，只需要比较前array.length-1个的最大值
 *    所以，内循环中设置的边界为j<array.length-1-i
 *
 */
public class OptimizeBubbleSort {

    public static void main(String[] args) {
        OptimizeBubbleSort optimizeBubbleSort = new OptimizeBubbleSort();
        int[] array = {10,20,60,5,2,18,90,26};
        optimizeBubbleSort.optimizeButtleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void optimizeButtleSort(int[] array){
        Boolean flag;
        int temp;
        if(array.length == 0){
            return ;
        }
        for(int i=0; i<array.length; i++){
            flag = false;
            for(int j=0; j<array.length-1-i; j++){
                if(array[j+1] < array[j]){
                    flag = true;
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
            if(flag == false){
                //说明内循环中后一个数都比前一个大,本身就是有序的
                return ;
            }
        }
    }
}
