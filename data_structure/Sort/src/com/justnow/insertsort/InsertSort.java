package com.justnow.insertsort;

import java.util.Arrays;

/**
 * 1、第一次循环，确定前两个元素为有序序列；第二次循环，确定前三个元素为有序序列。。。。。
 * 2、在for循环中，i为该次确定有序序列的最后一个的位数。
 * 3、
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {2,10,4,8,19,17};
        insertSort.sort(array);
        System.out.println(Arrays.toString(array));

    }

    public void sort(int[] array){
        if(array.length == 0){
            return ;
        }
        for(int i=1; i<array.length; i++){
            int j = i;
            int temp = array[i];
            //如果array[i]小于i之前的有序序列的话，需要将array[i]插入到有序序列的适当位置。如果待插入元素与有序序列的某个元素相等的话，则将待插元素插入到相等元素的后面
            while(j>0&&temp<array[j-1]){
                //通过复制，是数组内容往后移
                array[j] = array[j-1];
                j--;
            }
            //该条件成立，则j为待插入的位置，所以将array[i]中的值放进去
            if(j!=i){
                array[j] = temp;
            }
        }
    }
}
