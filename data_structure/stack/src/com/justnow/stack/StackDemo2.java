package com.justnow.stack;


import javafx.beans.binding.ObjectExpression;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 1、可以自动扩容
 * 2、能存储各种不同类型的数据
 */
public class StackDemo2 {
    private Object[] elementData;
    private int top;
    private int size;

    public StackDemo2(){
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public StackDemo2(int initailCapacity){
        if(initailCapacity < 0){
            throw new IllegalArgumentException("栈初始容量不能小于0"+initailCapacity);
        }
        this.elementData = new Object[initailCapacity];
        this.top = -1;
        this.size = initailCapacity;
    }

    /**
     * 是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
     * @param minCapacity
     * @return
     */
    public boolean isGrow(int minCapacity){
        int oldCapacity = size;
        //如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
        if(minCapacity >= oldCapacity){
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            //栈容量扩大一倍(左移一位)看是否超过int类型所表示的最大范围
            if((oldCapacity<<1) - Integer.MAX_VALUE > 0){
                newCapacity = Integer.MAX_VALUE;
            }else{
                newCapacity = (oldCapacity<<1);//左移一位，相当于*2
            }
            this.size = newCapacity;
            elementData = Arrays.copyOf(elementData, size);
            return true;
        }else{
            return false;
        }
    }

    //压入元素
    public void push(Object item){
        //是否要扩容
        isGrow(top+1);
        elementData[++top] = item;
    }

    //删除栈顶元素
    public void remove(int top){
        //栈顶元素为null
        elementData[top] = null;
        this.top--;
    }

    //获取栈顶元素
    public Object peek(){
        if(top == -1){
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    //弹出栈顶元素
    public Object pop(){
        Object obj = peek();
        remove(top);
        return obj;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }
}
