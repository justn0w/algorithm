package com.justnow.offer;

public class Solution {

    public static void main(String[] args) {
        for(int i=0; i<=10; i++)
            System.out.println(Fibonacci(i));
    }
    public static int Fibonacci(int n) {
        int result = 0;
        int add1=0;
        int add2=1;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        for (int i=2; i <= n; i++){
            result = add1 + add2;
            add1= add2;
            add2 = result;
        }
        return result;
    }
}
