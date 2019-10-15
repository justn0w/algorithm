package com.justnow.radixsort;

import java.lang.reflect.Array;
import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {21, 56, 1};
        int maxDigit = getMaxDigit(array);
        //System.out.println(maxDigit);
        sort(array);
    }

    /**
     * 1、获取数组中最大的数位
     * @param array
     * @return
     */
    public static int getMaxDigit(int[] array){
        int max = array[0];
        for(int value : array){
            if(max < value)
                max = value;
        }
        int count = 1;
        int div = 10;
        while(max / div > 0){
            div *= 10;
            count++;
        }
        return count;
    }

    public static int[] sort(int[] array){
        int maxDigit = getMaxDigit(array);
        List<List<Integer>> sortArray = new ArrayList<>();

        for(int i=0; i<maxDigit; i++){
            System.out.println("第"+i+"次排序"+"\n------------------------------");
            System.out.println(Arrays.toString(array));
            for(int j=0; j<10;j++){
                List<Integer> newArray = new ArrayList<>();
                List<Integer> zeroArray = new ArrayList<>();
                int dev = (int) Math.pow(10, (i+1));
                // 获取java位数的方法
                String temp;
                int length;
                for(int value : array){
                    temp = String.valueOf(value);
                    length = temp.length();
                    if ((length-i-1)<0 ){
                        zeroArray.add(value);
                    } else if(Integer.parseInt(String.valueOf(temp.charAt(length -i - 1))) == j){
                        newArray.add(value);
                    }
                }

                sortArray.add(j, newArray);
                if(zeroArray.size() > 0){
                    sortArray.set(0, zeroArray);
                }
                System.out.println("第"+j+"行的内容"+sortArray.get(j).toString());
            }

            int n = 0;
            for (List<Integer> list : sortArray) {
                if (list.size() > 0 ){
                     for (Integer integer : list) {
                        array[n] = integer;
                        n++;
                    }
                }
            }
        }

        return array;

    }




}
