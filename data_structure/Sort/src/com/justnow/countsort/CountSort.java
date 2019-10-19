package com.justnow.countsort;

//https://www.cnblogs.com/kyoner/p/10604781.html

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] array = {3, -1, 3, 3, 1};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void countSort(int[] array){
        //1. 获取最大值和最小值
        int min = getMaxAndMin(array)[0];
        int max = getMaxAndMin(array)[1];
        System.out.println(min+":"+max);
        //2. 创建一个新的数组
        int[] mySort = new int[max-min+1];
        for(int i=0; i<mySort.length; i++)
            mySort[i] = 0;

        //3. 获取每个元素的个数,通过n-min，判读元素值一致的个数
        for(int n : array){
            mySort[n-min] += 1;
        }
        //4. 计算每个元素所在的位置
/*        for(int j=1; j<mySort.length; j++){
            mySort[j] += mySort[j-1];
        }*/
        System.out.println(Arrays.toString(mySort));
        //5. 将内容输出到结果中
        int index=0;
        for(int m=0; m<mySort.length;m++){
            while(mySort[m]>0){
                array[index] = m+min;
                index++;
                mySort[m]--;
            }
        }

    }

    public static int[] getMaxAndMin(int[] array){
        int[] minAndMax = new int[2];
        int max = array[0];
        int min = array[0];
        for(int i=1; i<array.length; i++){
            if(max<array[i])
                max = array[i];
            if(min>array[i])
                min = array[i];
        }

        minAndMax[0] = min;
        minAndMax[1] = max;
        return minAndMax;
    }
}
