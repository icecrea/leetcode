package com.example.nowcoder.swordmeansoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @description: 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: icecrea
 * @create: 2019-05-08 14:47
 **/
public class Sword28_LeastNumber {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(Integer i : input){
            queue.add(i);
        }
        for(int i=0;i<k;i++){
            Integer poll = queue.poll();
            list.add(poll);
        }
        return list;
    }

    @Test
    public void test(){
        ArrayList<Integer> integers = GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println(integers);
    }
}
