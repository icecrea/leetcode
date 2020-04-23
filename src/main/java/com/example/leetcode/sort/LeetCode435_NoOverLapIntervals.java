package com.example.leetcode.sort;

import java.util.List;

/**
 * @description: 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @auther: icecrea
 * @date: 2020/4/22
 */
public class LeetCode435_NoOverLapIntervals {
    public int eraseOverlapIntervals(List<Interval> intervals) {
        return intervals.size() - intervalSchedule(intervals);
    }

    /**
     * 求不重叠的区间个数
     */
    public int intervalSchedule(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        // 按 end 升序排序
        intervals.sort((i1, i2) -> Integer.compare(i1.end, i2.end));
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int xEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            int start = interval.start;
            if (start >= xEnd) {
                // 找到下一个选择的区间了
                count++;
                xEnd = interval.end;
            }
        }
        return count;
    }
}
