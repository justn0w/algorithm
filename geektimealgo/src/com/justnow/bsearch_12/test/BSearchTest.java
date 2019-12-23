package com.justnow.bsearch_12.test;

import com.justnow.bsearch_12.BSearch;
import org.junit.Test;

public class BSearchTest {

    @Test
    public void testdeformation() {
        BSearch bSearch = new BSearch();
        int[] a = {1,2,3,4,5,6,6,6,7,8};
        int lastIndex = bSearch.findLastValue(a, 10, 6);
        //System.out.println(lastIndex);

        int[] a2 = {1,2,3,4,5};
        System.out.println(bSearch.findFirstGEValue(a, 10, 3));
    }
}
