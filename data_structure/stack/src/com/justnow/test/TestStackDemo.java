package com.justnow.test;

import com.justnow.stack.StackDemo;
import com.justnow.stack.StackDemo2;
import org.junit.Test;

public class TestStackDemo {

    @Test
    public void test1(){
        StackDemo stackDemo = new StackDemo(3);
        stackDemo.push(1);
        stackDemo.push(2);
        stackDemo.push(3);
        stackDemo.push(4);
        stackDemo.pop();
        System.out.println(stackDemo.peek());
    }

    @Test
    public void test2(){
        StackDemo2 stackDemo2 = new StackDemo2(3);
        stackDemo2.push(1);
        stackDemo2.push(2);
        stackDemo2.push(3);
        stackDemo2.push("4");
        System.out.println(stackDemo2.peek());
    }
}
