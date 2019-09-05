package com.example.swordoffer;

import java.util.Stack;

/**
 * @description: 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: icecrea
 * @create: 2019-04-17 13:09
 **/
public class Sword5_QueuingWithTwoStacks {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 用例:
     * ["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
     * <p>
     * 对应输出应该为:
     * <p>
     * 1,2,3,4,5
     *
     *
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        //当stack2为空时，一次压入stack1中全部全元素。 即栈1每次出栈时，弹出所有元素
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        //不为空时，弹出栈顶元素
        return stack2.pop();
    }
}
