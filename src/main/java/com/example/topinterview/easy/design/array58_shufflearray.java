package com.example.topinterview.easy.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class array58_shufflearray {

    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public array58_shufflearray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        //因为orig已经赋值给array 有可能被修改 需要克隆一份返回保证不变
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 233, 4, 5};
        int[] clone = a.clone();
        a[0] = 10;
        System.out.println(a[0]);
        System.out.println(clone[0]);
    }


}
