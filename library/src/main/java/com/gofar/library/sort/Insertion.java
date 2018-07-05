package com.gofar.library.sort;

/**
 * 插入排序
 * 前n个数是有序的，将第n+1个数与相邻的前一个数n比较，比它小(或大）就交换位置，再将n与n-1比较，直到都有序
 * 初始有序的数据越多，交换次数越小
 *
 * @author lcf
 * @date 2018/7/5 14:50
 * @since 1.0
 */
public class Insertion<T extends Comparable<T>> extends BaseSort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            // 前i个数是有序的，第i+1个数依次与它前面的数i,i-...0相比较直到满足条件
            for (int j = i; j > 0; j--) {
                // 向前比较，如果比前一个数小就交换位置
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }
}
