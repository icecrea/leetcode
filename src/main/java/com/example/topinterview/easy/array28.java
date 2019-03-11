package com.example.topinterview.easy;

/**
 * @description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @author: icecrea
 * @create: 2019-02-26 10:41
 **/
public class array28 {
    /**
     * 不等于0的依次从0给数组赋值，剩下的数组位置全置为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for(int i=index;i<nums.length;i++){
           nums[i]=0;
        }
    }
}
