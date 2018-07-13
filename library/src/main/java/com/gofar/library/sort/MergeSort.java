package com.gofar.library.sort;

/**
 * 归并排序
 * 将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的，然后再把有序子序列合并成整体有序序列。
 * 稳定排序方式
 * 时间复杂度：O(nlogn)
 *
 * @author lcf
 * @date 13/7/2018 下午 3:38
 * @since 1.0
 */
public class MergeSort {
    public void sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移到新数组中
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边剩余的数移到新数组中
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 新数组中的数替换原数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
}
