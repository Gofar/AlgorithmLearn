package com.gofar.lib_run.review1;

/**
 * @author lcf
 * @date 23/7/2018 上午 11:30
 * @since 1.0
 */
public class SwapHelper {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
