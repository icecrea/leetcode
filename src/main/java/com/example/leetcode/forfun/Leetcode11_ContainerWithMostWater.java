package com.example.leetcode.forfun;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description:
 * @author: icecrea
 * @create: 2018-12-24 17:48
 **/
public class Leetcode11_ContainerWithMostWater {

    /**
     * leetcode 11 盛水最多的容器
     * https://leetcode-cn.com/problems/container-with-most-water/
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 示例
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    /**
     * 使用两个指针，一个放在开始，一个置于末尾。
     * 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，
     * 并将指向较短线段的指针向较长线段那端移动一步。
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
