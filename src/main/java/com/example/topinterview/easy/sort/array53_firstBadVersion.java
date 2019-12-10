package com.example.topinterview.easy.sort;

import org.junit.Test;

/**
 * @description: 第一个错误版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 * @author: icecrea
 * @create: 2019-03-18 15:24
 **/
public class array53_firstBadVersion {

    private boolean isBadVersion(int version) {
        if (version >= 3) {
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    end = mid;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 根据题意，前提条件：当前数字n内必然是存在错误版本的
     * 和常规二分解法有区别 返回的是start 同时判断条件是 start < end
     * 可以结合123 分别为false true true 和 false false true情况分析
     */
    public int firstBadVersion2(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    @Test
    public void test() {
        System.out.println(firstBadVersion(3));
        System.out.println(firstBadVersion2(3));
    }

}
