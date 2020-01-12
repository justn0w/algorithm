package com.justnow.offer;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        Integer top = queue.remove();
        System.out.println("队列头部的元素：" + top);
        int size = queue.size();
        System.out.println("队列的大小：" + size);
    }
}
