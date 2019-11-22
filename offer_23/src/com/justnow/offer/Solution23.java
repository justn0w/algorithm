package com.justnow.offer;

import java.util.Scanner;

public class Solution23 {
    public static void main(String[] args) {
/*
        System.out.println("请输入字符串");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println("请输入匹配模式");
        Scanner inRegex = new Scanner(System.in);
        String regex = in.nextLine();
        matchCore(str, regex);
*/
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', '*'};

        Solution23 solution = new Solution23();
        boolean match = solution.match(str, pattern);
        System.out.println(match);

    }

    /**
     * 这种解法存在的问题是，无法实现*可以匹配出现多次的情况！
     * @param str
     * @param regex
     */
    public static void matchCore(String str, String regex) {
        Boolean flag = true;
        String regexCurrent = regex;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == regexCurrent.charAt(i)) {
                continue;
            } else if (regexCurrent.charAt(i) == '.') {
                continue;
            } else if (regexCurrent.length()-3 >= i && regexCurrent.charAt(i+1) == '*' && regexCurrent.charAt(i+2) == str.charAt(i)) {
                // 拼接匹配模式
                String strPre = regexCurrent.substring(0, i);
                String strLast = regexCurrent.substring(i + 2, regexCurrent.length());
                regexCurrent = strPre + strLast;
            } else {
                flag = false;
                break;
            }
        }

        if (flag == false) {
            System.out.println(str+"与"+regex+"不匹配");
        } else {
            System.out.println(str+"与"+regex+"匹配");
        }
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
