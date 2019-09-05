package com.example.swordoffer;

import java.util.Stack;

/**
 * @description: 包含Min的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: icecrea
 * @create: 2019-04-18 23:37
 **/
public class Sword19_StackWithMin {

    /**
     * 注意需要初始化
     */
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (stackMin.empty()) {
            stackMin.push(node);
        } else if (stackMin.peek() >= node) {
            stackMin.push(node);
        }
    }

    public void pop() {
        if(stackMin.peek().equals(stack.peek())) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
