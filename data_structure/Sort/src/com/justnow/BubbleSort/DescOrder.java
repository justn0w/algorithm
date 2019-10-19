package com.justnow.BubbleSort;

import java.util.Arrays;

public class DescOrder {
    public static void main(String[] args) {
        DescOrder desc = new DescOrder();
        int[] array = {2, 5, 10, 18, 20, 26, 60, 90};
        desc.descOrder(array);
        System.out.println(Arrays.toString(array));
    }

    public static void descOrder(int[] array){
        Boolean flag;
        int temp;
        for(int i=array.length-1; i>0; i--){
            flag = false;
            for(int j=array.length-1;j>array.length-i-1;j--){
                if(array[j-1] < array[j]){
                    flag = true;
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
            if(flag == false){
                return ;
            }
        }
    }


}
