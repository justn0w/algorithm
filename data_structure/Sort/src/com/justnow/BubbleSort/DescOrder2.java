package com.justnow.BubbleSort;

import java.util.Arrays;

public class DescOrder2 {
    public static void main(String[] args) {
        DescOrder2 descOrder = new DescOrder2();
        int[] array = {10,20,60,5,2,18,90,26};
        descOrder.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){
        if(array.length == 0){
            return ;
        }

        for (int i=0; i<array.length; i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]<array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
