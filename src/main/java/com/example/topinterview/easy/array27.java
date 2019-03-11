package com.example.topinterview.easy;

/**
 * @description: 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author: icecrea
 * @create: 2019-02-21 22:19
 **/
public class array27 {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        int z = Integer.parseInt(sb.toString()) + 1;
        String s = String.valueOf(z);
        int arr[] = new int[s.length()];
        for (int i = 0;i<s.length();i++){
            arr[i]= Integer.valueOf(s.charAt(i)+"");
        }
        return arr;
    }
}
