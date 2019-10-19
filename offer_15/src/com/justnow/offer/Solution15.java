package com.justnow.offer;

public class Solution15 {

    public int movingCount(int threhold, int rows, int cols) {
        int count = 0;
        if (threhold == 0 || rows < 1 || cols < 1) {
            return count;
        }

        //标识是否进入过
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }

        count = movingCountCore(threhold, rows, cols, 0, 0, visited);

        return count;
    }

    public int movingCountCore(int threhold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threhold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threhold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threhold, rows, cols, row, col + 1, visited) +
                    movingCountCore(threhold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threhold, rows, cols, row - 1, col, visited);
        }
        return count;
    }

    public boolean check(int threhold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && (getDigitSum(col) + getDigitSum(row)) <= threhold) {
            return true;
        }
        return false;
    }

    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
