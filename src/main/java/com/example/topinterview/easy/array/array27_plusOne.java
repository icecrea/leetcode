package com.example.topinterview.easy.array;

import com.example.swordoffer.Sword49_StrToInt;
import org.junit.Test;

/**
 * @description: 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author: icecrea
 * @create: 2019-02-21 22:19
 **/
public class array27_plusOne {
    /**
     * 注意溢出问题
     * 其实就是字符串转整数问题
     * 但是这里是一个数组 所以思路可能有变化
     *
     * @see Sword49_StrToInt
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                break;
            }
            if (carry == 1) {
                int cur = digits[i] + carry;
                digits[i] = cur % 10;
                carry = cur / 10;
            }
        }
        //数组需要扩容情况
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }


    /**
     * 优化简洁版
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //走到此处就说明有进位 需要+1
            digits[i]++;
            digits[i] = digits[i] % 10;
            //没进位 直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        //如果有超过数组长度的进位，只有9,99,99..这种情况，所以结果必然是100...
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    @Test
    public void test() {
        int[] ints = plusOne(new int[]{1, 2, 3, 9});
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
