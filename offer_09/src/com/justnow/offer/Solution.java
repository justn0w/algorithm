package com.justnow.offer;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "个台阶的方案个数为： " + totalSolutions(i));
            System.out.println(i + "个台阶的方案个数为： " + totalSolutions2(i));
        }
    }

    /**
     * 采用递归的思想
     * @param n
     * @return
     */
    public static int totalSolutions(int n){

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return totalSolutions(n-1) + totalSolutions(n-2);
    }

    /**
     * 用循环的方式
     * @param n
     * @return
     */
    public static int totalSolutions2(int n) {

        if (n <= 2) {
            return n;
        }

        //初始化两个加数
        int result=0;
        int add1 = 1;
        int add2 = 2;

        //这里i为所对应的台阶数
        for (int i=3; i <= n; i++){
            result = add1 + add2;
            add1 = add2;
            add2 = result;
        }

        return result;

    }
}
