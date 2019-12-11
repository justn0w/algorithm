package com.justnow.offer;

/**
 * 面试题20： 表示数值的字符串
 */
public class Solution25 {
    /**
     * 用来索引数组
     */
    public int index = 0;

    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }
        // 先判断是否存在符号
        boolean numeric = scanInteger(str);
        // 如果出现'.'，则接下来是数字的小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            // 使用'||'的原因
            // 1. 小数可以没有整数部分，如.123等于0.123
            // 2. 小数点后面可以没有数字，如233.等于233.0
            // 3. 当然，小数点前面和后面可以都有数字，如233.666
            numeric = scanUnsignedInteger(str) || numeric;
        }

        // 如果出现'e' 或者'E'，则接下来是数字的指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;

            // 使用'&&'的原因
            //1. 当e或E前面没有数字时，整个字符串不能表示数字，如.e1、e1;
            //2. 当e或E后面没有整数时，整个字符串不能表示数字，如12e、12e+5.4
            numeric = numeric && scanInteger(str);
        }
        // 扫描到最后一个元素，才可以结束判断
        return numeric && (index ==str.length);
    }

    /**
     * 扫描是否整数部分是否存在符号，若存在，跳转到判断下一位的无符号整型的情形
     * @param str
     * @return
     */
    public boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }


    /**
     * 扫描判断是否是无符号整数，循环扫描直到不是为止，同时如果index值大于start后，才可以返回true，记为无符号整数
     * @param str
     * @return
     */
    public boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > start;
    }

}
