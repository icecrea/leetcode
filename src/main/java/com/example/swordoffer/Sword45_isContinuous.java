package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @author: icecrea
 * @create: 2019-05-21 23:59
 **/
public class Sword45_isContinuous {


    /**
     * 连续满足条件： max -min<5 且 无重复数字
     *
     * 重复数字可以开辟数组来判断
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length==0){
            return false;
        }

        int[] tmp = new int[14];
        int max = -1;
        int min = 14;
        //循环找到最大值最小值(0不计入)
        for (int number : numbers) {
            tmp[number]++;
            //忽略0的情况 放在最前面,防止进入判重逻辑
            if (number == 0) {
                continue;
            }
            if (tmp[number] > 1) {
                return false;
            }
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isContinuous(new int[]{1,2,5,0,0}));
    }
}
