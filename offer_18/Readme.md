### 题目：
字符串的全排序，如输入"ABC",输出

A B C <br>
A C B <br>
B A C <br>
B C A <br>
C B A <br>
C A B 

---
#### 1 思路

从字符串数组中每次选取一个元素，作为结果中的第一个元素。然后对剩余的元素全排列，步骤跟上一步一样。
用递归来解决这个问题
##### 1.1 递归的抽象表达式
* 设一组数p = {s1, s2, s3, ... , sn}
* 全排列为perm(p), pn = p - {sn}

因此，perm(p) = s1 perm(p1), s2 perm(p2), s3 perm(p3),...,sn perm(pn)。
当n=1时，perm(p) = s1

##### 1.2 递归结束条件：当我们需要排列的元素为最后一个时就结束递归

---
#### 2 代码实现
代码说明，
```java
allPermutate2(["A", "B", "c"], 0, 2) {

   if {
        不执行} 
     
   if (from 不等于 to) {
        不执行}
   else {
       for 
         (1) i = 0, 0 <= 2, {
             swap(["A", "B", "c"], 0, 0);
             allPermutate2(["A", "B", "c"], 1, 2) {
                 if {
                    不执行
                 }
                 if (from=1 不等于2 ) {
                     不执行
                 } else {
                     for
                        (1) i = 1, 1 <= 2,
                            swap(["A", "B", "c"], 1, 1);
                            allPermutate2(["A", "B", "c"], 2, 2) {
                                打印结果A,B,C
                            };
                            swap(["A", "B", "c"], 1, 1);
                        (2) i=2, 1 <= 2,
                            swap(["A", "B", "c"], 2, 1);
                            allPermutate2(["A", "C", "B"], 2, 2) {
                                打印结果A,C,B
                            };
                            swap(["A", "C", "B"], 1, 2);//结果为["A", "B", "C"]
                        (3) i=3, i的值大于2，退出for循环
                 }
                }
             swap(["A", "B", "c"], 0, 0);
             }
         (2) i = 1, 1 <= 2, {
            swap(["A", "B", "c"], 1, 0);// 将B当作前缀来处理
            allPermutate2(["B", "A", "c"], 1, 2){
                //....内容大同小异
            }
            swap(["B", "A", "c"], 0, 1);
             }
        
    
   
    
}
```

上面的是伪代码

---


```java
    public static void allPermutate2(String[] str, int from, int to) {
        if (to < 1)
            return;
        if (from == to) { // 说明此时，只对一个元素进行全排列，没有再排列的必要了，直接将结果打印出来
            System.out.println(Arrays.toString(str));
        } else {
            for (int i = from; i <= to ; i++) {
                swap(str, i, from); // 交换前缀，使其产生下一个前缀
                allPermutate2(str, from+1, to);
                swap(str, from ,i); // 将前缀换回，继续做上一个前缀的排列
            }
        }
    }

```

---
#### 3 总结
* 使用for循环时，尽量使用具体含义的单词

