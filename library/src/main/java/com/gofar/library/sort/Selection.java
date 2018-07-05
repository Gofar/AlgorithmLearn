package com.gofar.library.sort;

/**
 * 选择排序
 * 选择最小的元素与第一个元素交换，再从剩下的元素中选择最小的与第二位交换
 * 不断这样排序，直到整个数组排序完成
 *
 * @author lcf
 * @date 2018/7/5 14:24
 * @since 1.0
 */
public class Selection<T extends Comparable<T>> extends BaseSort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}
