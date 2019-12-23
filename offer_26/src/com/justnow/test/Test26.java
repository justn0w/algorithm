package com.justnow.test;

import com.justnow.offer.Solution26;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Arrays;

public class Test26 {
    Solution26 solution = new Solution26();

    @Test
    public void testSolution01() {
        int[] a = {1,2,3,4,5,6,7,8,9,10,12};
        a = solution.sortArrays01(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testSolution02() {
        int[] a = {1,2,3,4,5,6,7,8,9,10,12};
        a = solution.sortArrays02(a);
        System.out.println(Arrays.toString(a));
    }
}
