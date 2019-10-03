剑指offer第八题<br>
题目：求斐波那契数列的第n项 <br>
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
数列如下：<br>
0,1,1,2,3,5,8,13......

---
思路分析：
1. 当我们想到斐波那契数列的时候，第一个冒出来的算法思想肯定是递归。但是，本题用循环也可以完美的解决。

2. add1看作第一个加数，add2看作第二个加数，result视为两者的和。
因为是从0开始的，所以可以初始化add1为0，add2为1。我们可以从第三项开始，```result=add1+add2```的值就是第三项的，然后把add2
的值赋给add1，同时把result的值赋值给add2，开启下一轮循环。

3. ```for(int i=2; i<=n ;i++)```,i=2时，result刚好是第三个元素的值。因为n是从0开始的，所以第三个元素就是数列的第2项；i=3时，result是第四个元素的值，为数列的第3项。

```java
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

```

