package com.justnow.offer;

public class Solution12 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int rs = findNumberOne(10000000);
        long end = System.currentTimeMillis();
        System.out.println(rs);
        System.out.println("程序运行的时间是"+ (end-start) + "ms");
    }

    /**
     * 最简单的顺序查找
     * @param n
     * @return
     */
    public static int findNumberOne(int n) {

        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 通过位运算巧妙的计算这个问题
     * @param n
     * @return
     */
    public static int findNumberOne2(int n) {
        int count = 0;
        while(n!=0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
