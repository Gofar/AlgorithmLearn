package com.gofar.lib_run;

import java.util.Arrays;

/**
 * @author lcf
 * @date 20/7/2018 下午 3:12
 * @since 1.0
 */
public class HeapSortF1 {
    public void sort(int[] nums) {
        int last = nums.length - 1;
        for (int i = 0; i < last; i++) {
            buildMaxHeap(nums, last - i);
            swap(nums, 0, last - i);
            System.out.println(Arrays.toString(nums));
        }
    }

    private void buildMaxHeap(int[] nums, int last) {
        for (int i = (last - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= last) {
                int j = 2 * k + 1;
                if (j < last && nums[j] < nums[j + 1]) {
                    j++;
                }
                if (nums[k] < nums[j]) {
                    swap(nums, k, j);
                    k = j;
                    System.out.println("build heap:" + Arrays.toString(nums));
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
