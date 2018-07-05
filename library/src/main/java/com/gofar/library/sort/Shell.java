package com.gofar.library.sort;

/**
 * 希尔排序
 *
 * @author lcf
 * @date 2018/7/5 16:40
 * @since 1.0
 */
public class Shell<T extends Comparable<T>> extends BaseSort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = N / 2;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(nums[j], nums[j - h])) {
                        swap(nums, j, h);
                    }
                }
                h = h / 2;
            }
        }
    }
}
