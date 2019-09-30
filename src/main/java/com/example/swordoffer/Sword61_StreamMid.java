package com.example.swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据流中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Sword61_StreamMid {

    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    /**
     * 1 1
     * 12 1.5
     * 123 2
     *
     * @return
     */
    public Double GetMedian() {
        int len = list.size();
        if ((len & 1) == 1) {
            return Double.valueOf(list.get(len >> 1));
        } else {
            Integer a1 = list.get(len >> 1 - 1);
            Integer a2 = list.get(len >> 1);
            return (a1 + a2) / 2D;
        }
    }


}
