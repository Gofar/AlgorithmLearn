package com.gofar.lib_run.review1;

import java.util.Arrays;

/**
 * @author lcf
 * @date 23/7/2018 上午 11:48
 * @since 1.0
 */
public class InsertSort {

    public void sort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    SwapHelper.swap(nums, j, j - 1);
                    System.out.println(Arrays.toString(nums));
                }
            }
        }
    }
}
