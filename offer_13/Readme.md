### 题目
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。


#### 1 容易忽视的地方

* exponent为负数
* base为0
* exponent为0
* exponent、base皆为0时，该怎么处理

如果在面试的时候把这些都考虑到，这个问题就很简单了。

#### 2 针对上述问题各个击破

##### 2.1 exponent为负数
如果exponent为负数，那么$base^exponent=-1/(base^abs(exponent))$，但是前提要判断底数为0的情况

#### 2.2 base为0
很简单结果就是0

#### 2.3 exponent为0
那么结果就是1

#### 2.4 两者皆为0
我们在这里定义其为1

```java

    public static double Power(double base, int exponent) {
        double result = 1.0;

        //1、底数为0，指数为负数的情况
        if ((base == 0.0) && (exponent < 0)) {
            return 0.0;
        }

        //2、底数和指数皆为0，此时可以用一个条件来汇总
        if (exponent == 0) {
            return 1.0;
        }

        for (int i=0; i<Math.abs(exponent); i++){
            result = result*base;
        }
        //3、判断是否负数的情况
        if (exponent < 0) {
            result = 1/result;
        }

        return result;
    }
```

