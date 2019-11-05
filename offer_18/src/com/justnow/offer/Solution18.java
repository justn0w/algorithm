package com.justnow.offer;

import java.util.Arrays;

/**
 * https://blog.csdn.net/lx678111/article/details/79538899
 * 好方法总结
 */
public class Solution18 {

    public static int count = 0;

    public static void swap(String str[], int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void allPermutate(String str[], int k, int length) {
        if (k == length - 1) {
            for (int i = 0; i < length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
            count++;
        } else {
            for (int i = k; i < length; i++) {
                swap(str, k, i);
                allPermutate(str, k + 1, length);
                swap(str, k, i);
            }
        }
    }

    /**
     * 使用第二个方法，结构更清晰
     * @param str
     * @param from
     * @param to
     */
    public static void allPermutate2(String[] str, int from, int to) {
        if (to < 1)
            return;
        if (from == to) { // 说明此时，只对一个元素进行全排列，没有再排列的必要了，直接将结果打印出来
            System.out.println(Arrays.toString(str));
        } else {
            for (int i = from; i <= to ; i++) {
                swap(str, i, from); // 交换前缀，使其产生下一个前缀
                allPermutate2(str, from+1, to);
                swap(str, from ,i); // 将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"A", "B", "C", "D"};
        //allPermutate(str, 0, str.length);
        allPermutate2(str, 0, str.length-1);
        //System.out.println(count);
    }

}

