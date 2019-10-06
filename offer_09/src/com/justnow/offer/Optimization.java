package com.justnow.offer;


public class Optimization {

    public int[] array;
    public Optimization(int n) {
        this.array = new int[n];
        for(int i=0; i<array.length; i++) {
            array[i] = -1;
        }
    }

    public int solution(int n) {
        System.out.println(n+"被计算了");
        if (n <= 2) {
            return 1;
        }

        return solution(n-1) + solution(n-2);
    }

    //使用数组进行递归问题优化
    public  int solution2(int n) {

        if (n <= 2) {
            return 1;
        }

        if(array[n] != -1) {
            return array[n];
        } else {
            array[n] = solution2(n-1) + solution2(n-2);
            return array[n];
        }
    }
}
