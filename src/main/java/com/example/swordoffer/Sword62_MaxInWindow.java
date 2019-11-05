package com.example.swordoffer;

import java.util.*;

/**
 * 滑动窗口最大值：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Sword62_MaxInWindow {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        Queue q = new LinkedList<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, Collections.reverseOrder());
        for (int i = 0; i < size; i++) {
            q.offer(num[i]);
            maxHeap.offer(num[i]);
        }
        //
        List result = new ArrayList();
        for (int i = size; i < num.length; i++) {
            result.add(maxHeap.poll());
            q.offer(num[i]);
        }
    }
}
