package com.example.swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Sword64_MaxInWindow {

    /**
     * 时间复杂度O(N)
     * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。队列第一个位置保存当前窗口的最大值。
     * 注意队列存的是最大值下标
     * 原则：对新来的元素k，将其与双端队列中的元素相比较
     * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值）
     * 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //队列左边元素最大
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();//从右往左遍历，比新来元素小的移除队列
            }
            qmax.addLast(i);
            //判断队首元素是否已经在窗口之外
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }


    /**
     * 使用大根堆，但是大根堆每次移除元素时间复杂度O(k)，取堆顶O(1)，总体时间复杂度高，为O(N*logk)
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue(size, Comparator.reverseOrder());
        for (int i = 0; i < num.length; i++) {
            if (q.size() == size) {
                q.remove(num[i - size]);
            }
            q.add(num[i]);
            if (i >= size - 1) {
                result.add(q.peek());
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return result;
    }

    @Test
    public void test() {
        LinkedList<Integer> qmax = new LinkedList<>();
        qmax.addLast(1);
        qmax.addLast(2);
        qmax.addLast(3);
        System.out.println(qmax);
        qmax.pollLast();
        System.out.println(qmax);
        maxInWindows2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
