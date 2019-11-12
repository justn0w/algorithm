### 题目
题目：输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印1、2、3一直到最大的3位数999。

---

#### 1 个人的解题思路

直接从1开始循环到n位十进制数，这的确是个方法。

#### 2 好的解法
##### 2.1 大数这个问题不能忽略
因为题目并没有限制n的大小，所以我们必须考虑到，如果要打印的数超过整型最大数时，该怎么办

##### 2.2 解决大数的问题
用字符串表示数字，可以解决这个问题

##### 2.3 更巧妙的地方
把问题转换成数字排列的解法，递归让代码更简洁。最终要打印的内容转化为n个0到9的全排列，至于全排列，当然是用递归来实现比较好

##### 2.4 避免输出字符串开头的零

个人的做法：从下标为0开始循环，将不是0的数字打印出来。这样做存在的问题是，如'00101',最终打印的内容是11，显然存在问题
优秀的做法：使用一个flag，并且初始化为true，当遇到第一个不为0的数字时，将其设置为false。代码如下：

```java
    private static void printNumber(char[] number) {
        int length = number.length;
        boolean isBeginZero = true;
        for (int i = 0; i < length; i++) {
            // 先申明isBeginZero为true，当遇到第一个不为0的字符时，将isBeginZero设置为false。
            // 此后，isBeginZero这个flag永远为false。说明，后面的数字都可以正常打印
            if (isBeginZero && number[i] != '0') {
                isBeginZero = false;
            }

            if (!isBeginZero) {
                System.out.print(number[i]);
            }
        }
        if (isBeginZero == false)
            System.out.println();
    }
```