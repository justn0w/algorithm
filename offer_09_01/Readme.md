### 题目描述：
在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。
请问计算出你可以采用多少种不同的方式爬完这个楼梯。
#### 输入描述：
一个正整数n(n<=100)，表示这个楼梯一共有多少阶
#### 输出描述：
一个正整数，表示有多少种不同的方式爬完这个楼梯
#### 示例
输入
5
输出
8

---
解题思路，本题其实考察的范围是对于大整数的处理问题。n=100时，要输出的结果超过了java中的最大正整数
$2^{31}-1=2147483647$。可以使用BigInterger来处理问题。
注：
[int的取值范围](https://blog.csdn.net/qfikh/article/details/52832087)
[java中的数据类型](https://blog.csdn.net/lucky123sky/article/details/54924411)


#### 1 BigInteger
* 用来表示任意大小的整数。
* 对BigInteger运算时，只能使用实例方法
* 与long型整数运算比，BigInteger不会有范围限制，但是后者计算的速度较慢
[进一步的解释](https://www.liaoxuefeng.com/wiki/1252599548343744/1279767986831393)

#### 2 java从命令行中读取内容
```java
Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
```

#### 3 最终的代码如下

```java
package com.justnow.offer;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 3) {
            System.out.println(n);
            return;
        }

        BigInteger add1 = BigInteger.valueOf(1);
        BigInteger add2 = BigInteger.valueOf(2);
        BigInteger result = BigInteger.valueOf(0);

        for (int i = 3; i < n; i++) {
            result = add1.add(add2);
            add1 = add2;
            add2 = result;
        }
        System.out.println(result);
    }
}
```






