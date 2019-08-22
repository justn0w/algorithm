package com.justnow.datastructure.Single.solution2;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void test(){
        SingleLinkedList list = new SingleLinkedList();
        list.addHead(10);
        list.addHead(9);
        list.addHead(8);
/*
        list.addHead(7);
        list.addHead(6);
        list.addHead(5);
        list.addHead(4);
        list.addHead(3);
        list.addHead(2);
        list.addHead(1);
        list.addHead(0);
*/
        list.display();
        list.insert(100,2);
        list.display();
    }
}
