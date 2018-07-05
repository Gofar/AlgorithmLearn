package com.gofar.library.sort;

/**
 * 冒泡排序
 * 相邻元素相互比较交换位置
 *
 * @author lcf
 * @date 2018/7/5 14:38
 * @since 1.0
 */
public class Bubble<T extends Comparable<T>> extends BaseSort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (less(nums[j + 1], nums[j])) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
