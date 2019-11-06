## 题目
实现函数```double Power(double base ,int exponent)```,求 ```base``` 的 ```exponent``` 次方。不得使用库函数，同时不需要考虑大数问题。
### 一 边界情况
* exponent 为负数的情况
* exponent 为0，但是base也为0.0的情况

我们需要自己定义0的0次方的输出结果，同时也要定义如果输入是0的负数次方该输出怎样的结果

### 二 对比书本代码
#### 1 用一个函数实现一般情况的计算。
```java
public static double getNormalPower(double base, int exponent) {
    double result = 1.0;
    for (int i = 0; i < exponent; i++) {
        result *= base;
    }
}
```


#### 2 当base为0.0，exponent为0时，此时不用再重复判断了

### 三 高效的代码
#### 1 求a的n次方可以用下面的方法来计算
* n为偶数，则a^n = a^(n/2) * a^(n/2);
* n为奇数，则a^n = a^((n-1)/2) * a^((n-1)/2) * a

所以，可以尝试用递归的方法来解决
#### 2 计算除以2和判断奇偶数
* exponent & 0x1 == 1 如果返回true说明是奇数
* exponent >> 1 得到的结果是除以2

整体上的代码为
```java
double getNormalPower(double base, int exponent) {
    if (exponent == 0) {
        return 1;
    }
    if (exponent == 1) {
        return base;
    }
    
    double result = getNormalPower(base, exponent >> 1);
    result *= result;
    if (exponent & 0x1 == 1) {
        result *= base;
    }
    
    return result;
}
```






