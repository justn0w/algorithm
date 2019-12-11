package com.justnow.test;

import com.justnow.offer.Solution25;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


public class Solution25Test {
    Solution25 solution = new Solution25();
    boolean numeric;

    @Test
    public void testNormal() {

        char[] str = {'1', '2'};
        numeric = this.solution.isNumeric(str);
        System.out.println(numeric);

    }

    @Test
    public void testE() {
        char[] str = {'-', '1', 'e', '-', '1', '9'};
        numeric = this.solution.isNumeric(str);
        System.out.println(numeric);
    }

    @Test
    public void test3() {
        // 测试12e
        char[] str = {'1', '2', '.'};
        numeric = this.solution.isNumeric(str);
        System.out.println(numeric);
    }

    @Test
    public void test4() {
        char[] str = {'1', '.', '2', 'e', '-', '1', '3'};
        numeric = this.solution.isNumeric(str);
        System.out.println(numeric);
    }

    @Test
    public void test5() {
        char[] str = {'.', '2', 'e', '-', '1', '3'};
        numeric = this.solution.isNumeric(str);
        System.out.println(numeric);
    }

}
