package com.example.topinterview.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author: icecrea
 * @create: 2019-02-20 09:51
 **/
public class array25 {
    /**
     * 若该数组有序，且有一个元素只出现一次，以步数2向后遍历，那么一定会存在a[i] != a[i+1]
     * 但排序时间复杂度不满足线性
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 >= nums.length) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 不容易想到的解法 亦或运算 相同为假，不同为真
     * 相同数字做^异或运算，会得到0， 所以相同的亦或结果都是0
     * 而剩下唯一的数，因为和0亦或0还为0，1亦或0为1，所以最后结果为唯一非双的数
     * 0010 0100
     * ^
     * 0010 0100
     * =
     * 0000 0000
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    @Test
    public void test() {
        int[] a = new int[]{4, 1, 2, 1, 2};
        int i = singleNumber(a);
        System.out.println(i);
    }
}
