package com.justnow.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Solution17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = scanner.next();
        System.out.print("得到的结果是:");
        getDecimalNumber(str);
    }

    public static int getDecimalNumber(String str) {
        if (str == null){
            return 0;
        }
        int sum = 0;
        int length = str.length();
        str.toUpperCase();
        Map<Character, Integer> letter = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            letter.put(new Character((char)(i+64)), i);
        }
/*
        for (int j = length-1; j >= 0; j--) {
            int decimal = letter.get(str.charAt(j));
            sum += (int)pow(26, j)*decimal;
        }
*/
/*
        for (int j = 0; j < length; j++) {
            int decimal = letter.get(str.charAt(j));
            sum += (int)pow(26, length-j-1)*decimal;
        }
*/
        for (int j = length-1; j >= 0; j--) {
            int decimal = letter.get(str.charAt(j));
            sum += (int)pow(26, length-1-j)*decimal;
        }
        System.out.println(sum);
        return sum;
    }
}
