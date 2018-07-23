package com.gofar.lib_run.review1;

import java.util.Arrays;

/**
 * @author lcf
 * @date 23/7/2018 上午 11:51
 * @since 1.0
 */
public class ShellSort {
    public void sort(int[] nums) {
        int length = nums.length;
        int increment = length / 2;
        while (increment > 0) {
            for (int i = increment; i < length; i++) {
                for (int j = i; j >= increment; j -= increment) {
                    if (nums[j] < nums[j - increment]) {
                        SwapHelper.swap(nums, j, j - increment);
                        System.out.println(Arrays.toString(nums));
                    }
                }
            }
            increment = increment / 2;
        }
    }
}
