## 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

## 分析
1. n=1时，只有1种方法。n=2时，有2种方法；
2. 当n>2时，第一次跳有两种情况：跳1级，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1);
跳2级时，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-2);
3. 因此n级台阶的不同跳法的总数时f(n) = f(n-1) + f(n-2)
4. 这是一个简单的斐波那契数列数列，直接来个递归就搞定了！





```java
package com.justnow.offer;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "个台阶的方案个数为： " + totalSOlutions(i));
        }
    }

    public static int totalSOlutions(int n){

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return totalSOlutions(n-1) + totalSOlutions(n-2);
    }
}
```

```java
使用循环：

    /**
     * 用循环的方式
     * @param n
     * @return
     */
    public static int totalSolutions2(int n) {

        if (n <= 2) {
            return n;
        }

        //初始化两个加数
        int result=0;
        int add1 = 1;
        int add2 = 2;

        //这里i为所对应的台阶数
        for (int i=3; i <= n; i++){
            result = add1 + add2;
            add1 = add2;
            add2 = result;
        }

        return result;

    }
```