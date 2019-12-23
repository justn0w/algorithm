package com.justnow.offer;

import java.util.Arrays;

public class Solution26 {


    /**
     * 我的方法，申请一个数组，从头到尾索引数组，奇数依次从头部插入到数组中，偶数依次从尾部插入到数组中，最终奇数在前，偶数在后
     * @param a
     * @return
     */
    public int[] sortArrays01(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int length = a.length;
        int[] array = new int[length];
        int indexEven = 0;
        int indexOdd = length - 1;
        for (int i = 0; i < length; i++) {
            if(a[i] % 2 == 1) {
                array[indexEven++] = a[i];
            } else {
                array[indexOdd--] = a[i];
            }
        }
        return array;
    }

    /**
     * 空间复杂度较小的方法
     * @param a
     * @return
     */
    public int[] sortArrays02(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        int length = a.length;
        int pHead = 0;
        int pTail = length - 1;

        while (pHead < pTail) {

/*
            // 向后移动pHead，直到它指向偶数
            while (pHead < pTail && (a[pHead] % 2 == 0)) {
                pHead++;
            }

            // 向前移动PEnd，直到它指向奇数
            while (pHead < pTail && (a[pTail] % 2 == 1)) {
                pTail--;
            }
*/
            // 使用&来判断奇偶性

            // 向后移动pHead，直到它指向偶数
            while (pHead < pTail && (a[pHead] & 0x1) == 0) {
                pHead++;
            }

            // 向前移动PEnd，直到它指向奇数
            while (pHead < pTail && (a[pTail] & 0x1) == 1) {
                pTail--;
            }

            if (pHead < pTail) {
                int temp = a[pHead];
                a[pHead] = a[pTail];
                a[pTail] = temp;
            }
        }
        return a;
    }

    /**
     * 将这个方法模块化，实现解耦，逻辑框架抽象出来
     * 把整个函数解耦成两个部分：
     * (1) 判断数字应该是在数组前半部分还是后半部分,即isEven函数
     * (2) 进行调换的操作
     * @param a
     * @return
     */
    public int[] reOrder(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        int length = a.length;
        int pHead = 0;
        int pTail = length - 1;

        while (pHead < pTail) {

/*
            // 向后移动pHead，直到它指向偶数
            while (pHead < pTail && (a[pHead] % 2 == 0)) {
                pHead++;
            }

            // 向前移动PEnd，直到它指向奇数
            while (pHead < pTail && (a[pTail] % 2 == 1)) {
                pTail--;
            }
*/
            // 使用&来判断奇偶性

            // 向后移动pHead，直到它指向偶数
            while (pHead < pTail && isEven(a[pHead])) {
                pHead++;
            }

            // 向前移动PEnd，直到它指向奇数
            while (pHead < pTail && isEven(a[pTail])) {
                pTail--;
            }

            if (pHead < pTail) {
                int temp = a[pHead];
                a[pHead] = a[pTail];
                a[pTail] = temp;
            }
        }
        return a;
    }

    public boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public void ReorderOddEvent(int[] a) {
        reOrder(a);
    }

}
