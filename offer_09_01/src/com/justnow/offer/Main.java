package com.justnow.offer;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 3) {
            System.out.println(n);
            return;
        }

        BigInteger add1 = BigInteger.valueOf(1);
        BigInteger add2 = BigInteger.valueOf(2);
        BigInteger result = BigInteger.valueOf(0);

        for (int i = 3; i < n; i++) {
            result = add1.add(add2);
            add1 = add2;
            add2 = result;
        }
        System.out.println(result);
    }
}
