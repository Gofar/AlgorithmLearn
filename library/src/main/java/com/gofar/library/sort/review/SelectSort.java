package com.gofar.library.sort.review;

/**
 * 选择排序
 * 在要排序的数组中选择最小的数与第一个位置的数交换，然后在剩下的数找到最小与第二位交换，
 * 如此循环知道倒数第二个数与最后一个数交换
 * 时间复杂度：O(n^2)，性能优于冒泡排序，交换次数少
 *
 * @author lcf
 * @date 16/7/2018 下午 3:03
 * @since 1.0
 */
public class SelectSort {
    public void sort(int[] nums) {
        int size = nums.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            int k = i;
            // j从前往后循环比较
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            // 交换
            if (k != i) {
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }

    public void sortF(int[] nums) {
        int size = nums.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            int k = i;
            // j从后往前循环比较
            for (int j = size - 1; j > i; j--) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            // 交换
            if (k != i) {
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }
}
