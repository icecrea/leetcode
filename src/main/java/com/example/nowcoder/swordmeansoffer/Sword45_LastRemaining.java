package com.example.nowcoder.swordmeansoffer;

import java.util.ArrayList;

/**
 * @description: 圆圈中最后剩下的数
 * <p>
 * <p>
 * 每年六一儿童节, 牛客都会准备一些小礼物去看望孤儿院的小朋友, 今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 * @author: icecrea
 * @create: 2019-09-04 23:26
 **/
public class Sword45_LastRemaining {

    /**
     * 通过list 的 size() 和remove()方法，每次remove后，size会动态变化，来实现环的效果
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || n == 0) {
            return -1;
        }

        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = 0;
        int step = m - 1;
        while (data.size() > 1) {
            index = (index + step) % data.size();
            data.remove(index);
        }
        return data.get(0);
    }


    /**
     * 通过数组实现，while循环中，记录步数并且找到对应数字后，标记删除，重置步数循环-1，直到最后一个数
     *
     * @param n
     * @param m
     * @return
     */
    public static int findLastNumber(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        //跳出循环时将最后一个元素也设置为了-1
        while (count > 0) {
            //指向上一个被删除对象的下一个元素。
            i++;
            if (i >= n) {
                //模拟环。
                i = 0;
            }
            if (array[i] == -1) {
                continue; //跳过被删除的对象。
            }
            //记录已走过的步数
            step++;
            //找到待删除的对象，删除、重置步数
            if (step == m) {
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        //返回跳出循环时的i,即最后一个被设置为-1的元素
        return i;
    }

}
