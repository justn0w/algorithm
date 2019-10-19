### 题目
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
例如 a b t g c f c s j d e h (3行4列)矩阵中包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

---
### 解题思路

#### 1 画图解思路
矩阵为：

a b t g <br> 
c f c s <br>
j d e h
---
寻找的路径：
bfce


* 先找到路径的第一个元素 'b'，在矩阵中的坐标为 (1行，2列)
* 因为路径的下一个元素为'f',所以我们需要找在1行2列元素的上下左右相邻元素，分别是a、t、f,其中只有2行2列的元素与路径中的第二元素相等。
* 选择第二个元素作为匹配的路径上的第二个元素。我们从坐标为(2,2)的元素着手，分别查看其上下左右是否存在与路径上第三个元素相等的内容。很辛运，坐标为(2,1)和(2,3)的元素符合要求。
* 现在假设矩阵中(2,1)的元素为路径的第三个元素，那么继续找第四个元素。很明显，没有符合的情况，那么说明(2,1)不行，我们只好回到第二个元素，然后以(2,3)为第三个元素。
* 继续这个过程，知道找到结果为止

#### 2 总结一般规律

当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个字符，这时候只好在路径上回到第n-1个字符，重新定位第
n个字符

**因为每一步都存在相同的步骤，所以我们可以尝试递归来解决这个问题**


#### 3 最终代码如下

```java
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
        
        //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
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

```

---

现在用一个例子走一遍这个过程

矩阵<br>
a b e g<br>
c f c s<br>
j d e h<br>
h i j k
---
寻找路径为： 'bfej'

1. 矩阵中(1,2)