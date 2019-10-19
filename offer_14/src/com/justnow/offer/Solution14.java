package com.justnow.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution14 {

    public static void main(String[] args) {
        char[] matrix = {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        int rows = 3;
        int cols = 4;
        char[] str = {'A', 'B', 'C', 'C', 'E', 'D'};
        System.out.println(hasPath(matrix, rows, cols, str));
    }


    /**
     * 该方法失败，逻辑不清晰，很混乱
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
/*
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        // 如果两者中有一个为空，说明输入内容有误
        if (matrix.length == 0 || str.length == 0 || matrix.length < str.length) {
            return false;
        }
        boolean flag=false;
        // 存储寻找路径
        List<Integer> findPath = new ArrayList<>();
        for (int i=0; i<str.length; i++) {
            if (flag == false && i==0) {
                for (int j = 0; j < matrix.length; j++) {
                    if (i == 0 && str[i] == matrix[j]) {
                        findPath.add(j);
                        flag = true;
                        break;
                    }
                }
            }
            if (i-1>=0 && str[i] == matrix[i-1] && !findPath.contains(i-2))  {
                findPath.add(i-2);
            }

            if (i+1<matrix.length && !findPath.contains(i) && str[i] == matrix[i]) {
                findPath.add(i);
            }

            if (i-cols-1>=0 && !findPath.contains(i-cols) && str[i] == matrix[i-cols-1]) {
                findPath.add(i-cols-1);
            }

            if (i+cols<matrix.length && !findPath.contains(i+cols-1) && str[i] == matrix[i+cols-1]) {
                findPath.add(i+cols-1);
            }
        }

        return true;
    }
*/

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || rows < 1 || cols < 1|| str == null) {
            return false;
        }

        //标识路径是否进入过这个格子，进入过后用true表示
        boolean[] visited = new boolean[rows * cols];

        //记录匹配路径的长度
        int pathLength = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }

            }
        }

        return false;
    }

    /**
     * 以坐标(row, col)为起点，递归判断是否存在路径
     * @param matrix
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param str
     * @param pathLength
     * @param visited
     * @return
     */
    public static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        //1. 递归终结条件，如果匹配的路径长度与str的长度一样，说明存在这条路径
        if (pathLength == str.length) {
            return true;
        }

        //2. 作为是否找到路径的flag
        boolean hasPath = false;

        //3. matrix坐标元素与坐标为pathLength的str元素相等是否相等
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            ++pathLength;
            //3.1 将该坐标下的格子标记为已进入
            visited[row * cols + col] = true;
            //3.2 递归判断该元素的上下左右元素是否与str中坐标为pathLength的元素相等，递归，直到pathLength == str.length
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);
            //3.3 如果hasPath结果为false，说明从该元素开始递归查找没有匹配到路径，需要回溯到该元素的上一个元素
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }

}
