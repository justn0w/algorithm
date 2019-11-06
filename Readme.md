
[如何刷算法题](https://www.zhihu.com/search?type=content&q=%E5%A6%82%E4%BD%95%E5%88%B7%E7%AE%97%E6%B3%95%E9%A2%98)




### 1 offer_09_01
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

### 2 offer_10
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

---

### 3 offer_11
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

---

### 3 offer_12
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

---

### 4 offer_13
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

---

### 5 offer_14
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

a b c e<br>
s f c s<br>
a d e e<br>

---
### 6 offer_15
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

---

### 7 offer_16
给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

#### 输入描述
> 输入一个数n，意义见题面。（2 <= n <= 60）

#### 输出描述:
> 输出答案。

### 8 offer_17
在微软产品Excel中，用A表示第1列，B表示第2列.....Z表示第26列,AA表示第27列, AB表示第28列......依次类推。请写出一个函数，输入用字母表示的列号编码，输出它是第几列。

## 第十周 周二
### 9 offer_18
字符串的全排序，如输入"ABC",输出
A B C <br>
A C B <br>
B A C <br>
B C A <br>
C B A <br>
C A B 

## 第十周 周三
### 10 offer_19
实现函数```double Power(double base ,int exponent)```,求 ```base``` 的 ```exponent``` 次方。不得使用库函数，同时不需要考虑大数问题。
