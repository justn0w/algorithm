package com.justnow.offer;

import java.util.Stack;

public class Solution35 {
    // 没有实例化会怎么样呢
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stackAssist = new Stack<Integer>();

    public void push(int value) {
        stack.push(value);
        if (stackAssist.size() == 0 || stackAssist.peek()> value) {
            stackAssist.push(value);
        } else {
            stackAssist.push(stackAssist.peek());
        }
    }

    public void pop() {
        if (stack.size() > 0 && stackAssist.size() > 0) {
            stack.pop();
            stackAssist.pop();
        }
    }

    public Integer min() {
        if (stackAssist.size() > 0) {
            return stackAssist.peek();
        }
        return -1;
    }
}
