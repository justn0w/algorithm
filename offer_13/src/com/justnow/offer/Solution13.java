package com.justnow.offer;

import java.util.Scanner;

public class Solution13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int count = 0;
        while(n!=0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
