package com.justnow.BubbleSort;

import java.util.Arrays;

public class BasicBubbleSort {
    public static void main(String[] args) {
        BasicBubbleSort basicBubbleSort = new BasicBubbleSort();
        int[] array = {10,20,60,5,2,18,90,60,26};
        basicBubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){
        if(array.length == 0){
            return ;
        }
        for(int i=0; i<array.length; i++){

            for(int j=0; j<array.length-1-i; j++){
                if(array[j+1] < array[j]){

                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
