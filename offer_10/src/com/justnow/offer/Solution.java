package com.justnow.offer;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double pow = Math.pow(2, n - 1);
        System.out.println((int)pow);
    }
}
