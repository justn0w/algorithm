package com.justnow.offer;



public class Solution20 {
    public static void main(String[] args) {
        //myPrint(0);
        myPrint2(2);
    }

    /**
     * 不考虑任何情况，最简单的方式
     * @param n
     */
    public static void myPrint(int n) {
        if (n <= 0) {
            return ;
        }
        int maxValue = (int) Math.pow(10, n);
        for (int i = 1; i < maxValue; i++) {
            System.out.println(i);
        }
    }

    public static void myPrint2(int n) {
        if (n <= 0) {
            System.out.println("输入的n没有意义");
            return ;
        }

        char[] number = new char[n];

        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        for (int i = 0; i < 10; ++i) {
            number[0] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, n , 0);
        }
    }

    private static void print1ToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if (index == n - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }

    /**
     * 从第一个不为0的数字开始输出
     * @param number
     */
    private static void printNumber(char[] number) {
        int length = number.length;
        boolean isBeginZero = true;
        for (int i = 0; i < length; i++) {
            // 先申明isBeginZero为true，当遇到第一个不为0的字符时，将isBeginZero设置为false。
            // 此后，isBeginZero这个flag永远为false。说明，后面的数字都可以正常打印
            if (isBeginZero && number[i] != '0') {
                isBeginZero = false;
            }

            if (!isBeginZero) {
                System.out.print(number[i]);
            }
        }
        if (isBeginZero == false)
            System.out.println();
    }
}
