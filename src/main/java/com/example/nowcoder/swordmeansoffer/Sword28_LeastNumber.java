package com.example.nowcoder.swordmeansoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @description: 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: icecrea
 * @create: 2019-05-08 14:47
 **/
public class Sword28_LeastNumber {

    /**
     * 全部放进小根堆，取前面k个
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (Integer i : input) {
            queue.add(i);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            list.add(poll);
        }
        return list;
    }

    /**
     * 维护容量为k的大根堆
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.remove();
                maxHeap.offer(input[i]);
            }
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.remove());
        }
        return result;
    }

    @Test
    public void test() {
        ArrayList<Integer> integers = GetLeastNumbers_Solution2(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println(integers);
    }
}
