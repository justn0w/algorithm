package com.justnow.sort01;

public class Sort_01 {
    public static void main(String[] args) {
        int[] age = {1,2,3,4,5,5,10,20,70,3,5,18,14,20};
        int length = age.length;
        Solution solution = new Solution(age, length);
        solution.sortAges();
        int[] testages = solution.ages;
        for (int i : testages) {
            System.out.println(i);
        }
    }
}

