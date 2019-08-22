package com.justnow.stack;

public class StackDemo {
    private int[] array;
    private int maxSize;
    private int top;

    public StackDemo(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //压入数据
    public void push(int value){
        if(top < maxSize - 1){
            array[++top] = value;
        }else{
            System.out.println("栈已满");
        }
    }

    //弹出栈顶数据
    public int pop(){
        return array[top--];
    }

    //访问栈顶元素
    public int peek(){
        return array[top];
    }
    //判断栈是否为空
    public boolean isEmpaty(){
        return (top == -1);
    }

    public void display(){
        for(int value : this.array){
            System.out.println(value);
        }
    }



}
