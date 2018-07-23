package com.gofar.lib_run.review1;

import java.util.Arrays;

/**
 * @author lcf
 * @date 23/7/2018 上午 11:28
 * @since 1.0
 */
public class BubbleSort {

    public void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    SwapHelper.swap(nums, j, j + 1);
                    System.out.println(Arrays.toString(nums));
                }
            }
        }
    }
}
