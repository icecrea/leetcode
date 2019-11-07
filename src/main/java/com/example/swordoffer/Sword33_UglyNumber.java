package com.example.swordoffer;

import java.util.ArrayList;

/**
 * @description: 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author: icecrea
 * @create: 2019-05-08 17:44
 **/
public class Sword33_UglyNumber {

    int GetUglyNumber_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        //循环的条件
        while (list.size() < n) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2) {
                i2++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
}
