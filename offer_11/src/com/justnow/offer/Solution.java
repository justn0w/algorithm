package com.justnow.offer;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long start = System.currentTimeMillis();
        System.out.println(RectCover(n));
        long end = System.currentTimeMillis();
        System.out.println("程序运行的时间是" + (end -start) + "ms");

    }

    public static int RectCover(int target) {
        //第一个条件一定要加上，要不然输入一个小于0的数，函数会出错
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }

        return RectCover(target - 1) + RectCover(target - 2);
    }
}
