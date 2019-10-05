package com.justnow.offer;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "个台阶的方案个数为： " + totalSOlutions(i));
        }
    }

    public static int totalSOlutions(int n){

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return totalSOlutions(n-1) + totalSOlutions(n-2);
    }
}
