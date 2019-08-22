package com.justnow.datastructure.Single.solution1;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void test(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");
        singleLinkedList.addHead("E");
        singleLinkedList.addHead("F");
        singleLinkedList.addHead("G");
        singleLinkedList.display();

        System.out.println(singleLinkedList.find("!"));
        singleLinkedList.delete("C");
        singleLinkedList.display();
    }

}
