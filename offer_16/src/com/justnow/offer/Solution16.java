package com.justnow.offer;

public class Solution16 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(getMaxResult(8));
        //边界测试
        for (int i=0; i < 5; i++) {
            System.out.println(getMaxResult(i));
        }

        /**
         * 对应的测试结果
         * 1
         * 1
         * 2
         * 4
         */
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
}
