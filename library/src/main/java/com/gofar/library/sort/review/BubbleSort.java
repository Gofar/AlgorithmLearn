package com.gofar.library.sort.review;

/**
 * 冒泡排序
 * 比较相邻的元素，如果第一个比第二个大，就交换它俩。
 * 时间复杂度:O(n^2)
 *
 * @author lcf
 * @date 16/7/2018 下午 2:52
 * @since 1.0
 */
public class BubbleSort {

    public void sort(int[] nums) {
        int size = nums.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
