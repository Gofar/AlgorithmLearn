package com.gofar.lib_run.review1;

/**
 * @author lcf
 * @date 23/7/2018 下午 3:22
 * @since 1.0
 */
public class HeapSort {
    public void sort(int[] nums) {
        int last = nums.length - 1;
        for (int i = 0; i < last; i++) {
            buildMaxHeap(nums, last - i);
            SwapHelper.swap(nums, 0, last - i);
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
                    SwapHelper.swap(nums, k, j);
                    k = j;
                } else {
                    break;
                }
            }
        }
    }
}
