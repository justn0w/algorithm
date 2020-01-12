package com.justnow.offer;

public class Solution34 {
    public void printMatrixClockwisely(int[][] numbers, int columns, int rows) {
        if (numbers == null || columns <=0 || rows <= 0) {
            return;
        }

        int start = 0;

        while(columns > start * 2 && rows > start * 2) {
            printMatrixCircle(numbers, columns, rows, start);
            ++start;
        }
    }

    private void printMatrixCircle(int[][] numbers, int columns, int rows, int start) {
        int endColumns = columns - 1 - start;//右下角的列数
        int endRows = rows - 1 - start;//右下角的行数

        //从左到右打印一行
        for (int i = start; i <= endColumns; ++i) {
            int number = numbers[start][i];
            System.out.print(number + " ");
        }

        //从上到下打印一列
        if (start < endRows) {
            for (int i = start + 1; i <= endRows; i++) {
                int number = numbers[i][endRows];
                System.out.print(number + " ");
            }
        }

        // 从右到左打印一行
        if (start < endColumns && start < endRows) {
            for (int i = endColumns - 1; i >= start; --i) {
                int number = numbers[endRows][i];
                System.out.print(number + " ");
            }
        }

        // 从下到上打印一列
        if (start < endColumns && start < endRows - 1) {
            for (int i = endRows - 1; i >= start + 1 ; --i) {
                int number = numbers[i][start];
                System.out.print(number + " ");
            }
        }
    }
}
