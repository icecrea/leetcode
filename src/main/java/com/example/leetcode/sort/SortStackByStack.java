package com.example.leetcode.sort;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 用一个栈排序另一个栈
 * @auther: icecrea
 * @date: 2020/4/24
 */
public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        //辅助数组
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            //如果数据栈顶的元素比help栈顶元素小，那么直接压入，否则，选择合适的位置压入
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        //此时数据栈为空，辅助栈是逆序的，将辅助栈依次弹出，压入到数据栈中
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    @Test
    public void test() {
        // 3 7
        // 34  22 7 3
        // 3 7 22 34
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(34);
        stack.push(22);
        sortStackByStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
