package com.gofar.lib_run.review1;

/**
 * @author lcf
 * @date 23/7/2018 下午 3:07
 * @since 1.0
 */
public class MergeSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            sort(nums, low, middle);
            sort(nums, middle + 1, high);
            merge(nums, low, middle, high);
        }
    }

    private void merge(int[] nums, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
