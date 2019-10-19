### 题目
给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

#### 输入描述
> 输入一个数n，意义见题面。（2 <= n <= 60）

#### 输出描述:
> 输出答案。

---

#### 解题思路
#### 1 动态规划

##### 条件一：求一个问题的最优解
##### 条件二：该问题能够分解成若干个子问题，并且子问题也存在最优解
##### 条件三：子问题之间还有重叠的更小的子问题

#### 2 本题思路
* 求剪出绳子长度的乘积的最大值，这个符合第一个条件
* 我们将乘积以函数表示，即f(n)。假设第一刀减在长度为i(0<i<n)的位置，于是把绳子剪成了长度分别为i和n-i两段。想要得到整个问题的最优解f(n),就需要同样用最优化的方法把长度为i和n-i的两段分别剪成若干段，使得它们剪出的每段绳子的长度成绩最大。这符合第二个条件。
* 大问题分解为小问题时，会出现相互重叠的更小的子问题。如，绳子长为10，首先将其分为4和6。长度为4的一段，可以分为2和2；长度为6的可以分为2和4。可以发现，f(2)是f(4)和f(6)公共的更小的子问题。

所以，这里采取的方法是自下而上的方法。先从小问题开始计算，并把已经解决的子问题的**最优解存储**下来（通常的做法是存储在一位数组或者二维数组中），并把子问题的最优解组合起来逐步解决大的问题。

#### 3 测试用例

* 功能测试用例：绳子的长度大于5
* 边界测试用例：绳子的长度分别为0,1,2,3,4


```java

```


