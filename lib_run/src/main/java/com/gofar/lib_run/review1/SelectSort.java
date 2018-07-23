package com.gofar.lib_run.review1;

import java.util.Arrays;

/**
 * @author lcf
 * @date 23/7/2018 上午 11:34
 * @since 1.0
 */
public class SelectSort {
    public void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            if (k != i) {
                SwapHelper.swap(nums, i, k);
                System.out.println(Arrays.toString(nums));
            }
        }
    }
}
