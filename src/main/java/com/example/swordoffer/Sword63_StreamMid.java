package com.example.swordoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中位数 LeetCode295
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class Sword63_StreamMid {

    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public Sword63_StreamMid() {
        count = 0;
        maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        minheap = new PriorityQueue<>();
    }


    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        //如果现在小顶堆数量比大顶堆还多，需要再移动到大顶堆
        if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    /**
     * 省略比较操作：
     * 右移情况，可以先加入大根堆，再移动到小跟堆
     * 左移情况，可以先加入小根堆，再移动到大跟堆
     * 这样操作省去了每次和堆顶的比较，代码比较容易写，但是增加了堆内排序的时间复杂度。
     */
    public void addNum2(int num) {
        count++;
        if (maxheap.size() == minheap.size()) {
            maxheap.add(num);
            minheap.add(maxheap.poll());
            maxheap.add(minheap.poll());
        } else if (maxheap.size() > minheap.size()) {
            //右移
            maxheap.add(num);
            minheap.add(maxheap.poll());
        } else {
            //左移情况，可以先加入小根堆，再移动到大跟堆
            minheap.add(num);
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
        }
    }

    public static void main(String[] args) {
        Sword63_StreamMid main = new Sword63_StreamMid();
        main.addNum(4);
        main.addNum(9);
        main.addNum(5);
        main.addNum(6);
        System.out.println(main.findMedian());
    }


}
