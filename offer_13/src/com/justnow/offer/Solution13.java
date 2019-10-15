package com.justnow.offer;

public class Solution13 {
    public static void main(String[] args) {
        System.out.println(Power(3, 20));
    }

    public static double Power(double base, int exponent) {
        double result = 1.0;

        //1、底数为0，指数为负数的情况
        if ((base == 0.0) && (exponent < 0)) {
            return 0.0;
        }

        //2、底数和指数皆为0，此时可以用一个条件来汇总
        if (exponent == 0) {
            return 1.0;
        }

        for (int i=0; i<Math.abs(exponent); i++){
            result = result*base;
        }
        //3、判断是否负数的情况
        if (exponent < 0) {
            result = 1/result;
        }

        return result;
    }
}
