package com.justnow.offer;

public class Solution19 {

    public static void main(String[] args) {
        double base = 2.5;
        int exponent = 2;
        double v = myPower(2.5, 2);
        System.out.println(v);
        System.out.println(myPower2(0.25, -1));
        System.out.println(myPower2(0.0, 0));
        System.out.println(myPower2(0.0, -10));
        System.out.println(myPower2(5.0, 200));
    }

    /**
     * 方法一
     * @param base
     * @param exponent
     * @return
     */
    public static double myPower(double base, int exponent) {
        double result = 1.0;
        for (int i=0; i < exponent; i++) {
            result = base * result;
        }
        return result;
    }

    /**
     * 方法二：
     * 1、exponent为0
     * 2、exponent为负数时如何处理
     * @param base
     * @param exponent
     * @return
     */
    public static double myPower2(double base, int exponent) {
        double result = 1.0;
        boolean isMinus = false;
        // exponent为0
        if (exponent == 0 && base == 0.0) {
            return 0.0;
        }
        // exponent为负数
        if (exponent < 0 && base == 0.0) {
            return 0.0;
        }

        if (exponent < 0) {
            exponent = -1 * exponent;
            isMinus = true;
        }

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        if (isMinus == true) {
            result = 1/result;
        }
        return result;
    }

    /**
     * 方法三，书上的方法
     * 与本人的方法，大同小异，但是很聪明用了个函数，来计算base的exponent次方
     * @param base
     * @param exponent
     * @return
     */
    public static double myPower3(double base, int exponent) {
        int absExponent;
        if (base == 0.0 && exponent < 0) {
            return 0.0;
        }

        absExponent = exponent;
        if (exponent < 0) {
            absExponent = -1 * exponent;
        }

        //double result = getNormalPower(base, absExponent);
        double result = getNormalPower2(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public static double getNormalPower(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static double getNormalPower2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = getNormalPower(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

}
