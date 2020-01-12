package com.justnow.test;

import com.justnow.offer.Solution34;
import org.junit.Test;

public class Solution34Test {

    @Test
    public void testNormal() {
        Solution34 solution = new Solution34();
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-8d", array[i][j]);
                //System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(".......................");
        solution.printMatrixClockwisely(array, 4, 4);
    }
}
