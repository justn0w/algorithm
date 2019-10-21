package com.justnow.offer;

import static java.lang.StrictMath.pow;

public class Solution16 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(getMaxResult(8));
        //边界测试
        for (int i=0; i < 10; i++) {
            System.out.println(getMaxResult(i));
            System.out.println(getMaxResult2(i));
        }
    }

    public static int getMaxResult(int length) {
        // 如果length小于等于3，则直接输出结果
        if (length < 2)
            return 1;
        if (length ==2)
            return 1;
        if (length == 3)
            return 2;

        // 如果length大于3，则又有新的内容
        int[] results = new int[length + 1];
        // 这里说明下，现在length大于4，那么当子问题分别为0,1,2,3时，我们直接不分不切割，此时就是子问题对应的最优解
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;//每次都有重置最大值，因为有可能上次求出的分段内容最大值大于f(j)*f(j-1)的值，最终得到的很有可能是上次的最大值
            for (int j = 1; j <= i / 2; ++j) {
                int result = results[j] * results[i-j];
                if (max < result) {
                    max = result;
                }
                results[i] = max;
            }
        }
        max = results[length];
        return max;
    }

    /**
     * 使用贪婪算法
     * @param length
     * @return
     */
    public static int getMaxResult2(int length) {
        // 如果length小于等于3，则直接输出结果
        if (length < 2)
            return 1;
        if (length ==2)
            return 1;
        if (length == 3)
            return 2;
        //求出可以切割成3的个数
        int timesof3 = length / 3;
        //当以3为单位来切割时，如果最后一段的长度为4，需求将最后一段按照2+2来切割
        if (length - timesof3 * 3 == 1) {
            timesof3--;
        }

        //求出可以剩余可以切割为2的个数
        int timesof2 = (length - timesof3 * 3) / 2;

        return (int)(pow(3, timesof3)) * (int)(pow(2, timesof2));
    }
}
