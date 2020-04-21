package com.example.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 区间交集
 * 给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 * 返回这两个区间列表的交集。
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 注意：输入和所需的输出都是区间对象组成的列表，而不是数组或列表。
 *  
 * 提示：
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/21
 */
public class LeetCode986_IntervalIntersections {

    /**
     * # A, B 形如 [[0,2],[5,10]...]
     * def intervalIntersection(A, B):
     * i, j = 0, 0 # 双指针
     * res = []
     * while i < len(A) and j < len(B):
     * aStart, aEnd = A[i][0], A[i][1]
     * bStart, bEnd = B[j][0], B[j][1]
     * # 两个区间存在交集
     * if bEnd >= aStart and aEnd >= bStart:
     * # 计算出交集，加入 res
     * res.append([max(aStart, bStart), min(aEnd, bEnd)])
     * # 指针前进
     * if bEnd < aEnd: j += 1
     * else:       i += 1
     * return res
     */
    public List<Interval> intervalIntersection(List<Interval> A, List<Interval> B) {
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            int aStart = A.get(i).start, aEnd = A.get(i).end;
            int bStart = B.get(i).start, bEnd = B.get(i).end;
            if (bEnd >= aStart && aEnd >= bStart) {
                res.add(new Interval(Math.max(aStart, bStart), Math.min(aEnd, bEnd)));
            }
            if (bEnd < aEnd) {
                j += 1;
            } else {
                i += 1;
            }
        }
        return res;
    }
}
