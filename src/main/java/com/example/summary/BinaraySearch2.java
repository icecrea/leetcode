package com.example.summary;

/**
 * @description: 二分查找升级版
 * @auther: icecrea
 * @date: 2020/4/28
 */
public class BinaraySearch2 {

    /**
     * 循环有序数组找最小值
     * 45123
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }


    /**
     * 循环有序数组找某个值
     * 333456
     * 34512
     */
    public int findMin2(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) { //左侧是有序的
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) { // 右侧从小到大有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[right]) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 求平方根
     */
    public int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x / 2, mid = 0;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            //防止mid * mid越界,使用除法
            if (mid <= (x / mid) && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }


}
