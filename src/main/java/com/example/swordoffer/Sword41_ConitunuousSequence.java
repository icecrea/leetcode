package com.example.swordoffer;

import java.util.ArrayList;

/**
 * @description: 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @author: icecrea
 * @create: 2019-05-09 13:07
 **/
public class Sword41_ConitunuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int left = 1, right = 2;
        //当low指针追上high指针时，退出循环，因为此时永远比Sum大，不可能再找到子序列。如Sum = 15,【[1, 2, 3, 4, 5]、[4, 5, 6]、[7, 8]】
        while (right > left) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (right + left) * (right - left + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                result.add(list);
                left++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                right++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                left++;
            }
        }
        return result;
    }
}
