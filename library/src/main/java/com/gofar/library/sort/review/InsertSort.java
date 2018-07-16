package com.gofar.library.sort.review;

/**
 * 插入排序
 * 前n-1个数是有序的，将第n个数与第n-1个数比较，若第n个数较小则第n个数与第n-1个数交换位置，
 * 然后比较第n-1个数与第n-2个数，如此循环比较直到所有数据有序。
 * 时间复杂度：O(n^2),性能上优于冒泡排序和选择排序
 *
 * @author lcf
 * @date 16/7/2018 下午 3:33
 * @since 1.0
 */
public class InsertSort {
    public void sort(int[] nums) {
        int size = nums.length;
        int temp;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                // 比前一个数小，就交换位置
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}