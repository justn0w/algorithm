package com.justnow.offer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Optimization optimization = new Optimization(n+1);
        int result = optimization.solution2(n);
        System.out.println(result);

    }


}
